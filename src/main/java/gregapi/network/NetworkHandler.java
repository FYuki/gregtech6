/**
 * Copyright (c) 2021 GregTech-6 Team
 *
 * This file is part of GregTech.
 *
 * GregTech is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * GregTech is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with GregTech. If not, see <http://www.gnu.org/licenses/>.
 */

package gregapi.network;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import gregapi.util.UT;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Gregorius Techneticies
 *
 * PHASE2 REWRITE: Replaced FMLEmbeddedChannel / FMLProxyPacket (removed in NeoForge 1.14+)
 * with the NeoForge 1.21 CustomPacketPayload + PacketDistributor API.
 *
 * Architecture:
 *  - A single GregPacketPayload wraps raw GT6 packet bytes plus a channel ID string.
 *    This avoids registering a separate payload type for every GT6 network channel.
 *  - All NetworkHandler instances register themselves in REGISTRY keyed by channelId.
 *  - registerPayloadHandlers() must be called from the mod bus RegisterPayloadHandlersEvent
 *    exactly ONCE (registered in gregapi.GT_API via @SubscribeEvent on the mod bus).
 */
public final class NetworkHandler implements INetworkHandler {

	// ---------------------------------------------------------------------------
	// Static payload registration (one payload type covers all GT6 channels)
	// ---------------------------------------------------------------------------

	/** Maps channelId → NetworkHandler so dispatching can find the right instance. */
	private static final Map<String, NetworkHandler> REGISTRY = new HashMap<>();

	/**
	 * Single NeoForge payload type that carries raw GT6 packet bytes.
	 * Registered once; the channelId field routes to the correct NetworkHandler.
	 */
	public record GregPacketPayload(String channelId, byte[] data) implements CustomPacketPayload {
		public static final Type<GregPacketPayload> TYPE =
			new Type<>(ResourceLocation.fromNamespaceAndPath("gregtech", "packet"));

		public static final StreamCodec<FriendlyByteBuf, GregPacketPayload> STREAM_CODEC = StreamCodec.of(
			(buf, payload) -> {
				buf.writeUtf(payload.channelId());
				buf.writeByteArray(payload.data());
			},
			buf -> new GregPacketPayload(buf.readUtf(), buf.readByteArray())
		);

		@Override
		public Type<? extends CustomPacketPayload> type() { return TYPE; }

		/** Dispatch to the owning NetworkHandler and execute the decoded IPacket. */
		public void handle(IPayloadContext ctx) {
			NetworkHandler handler = REGISTRY.get(channelId());
			if (handler == null) return;
			ctx.enqueueWork(() -> {
				ByteArrayDataInput in = ByteStreams.newDataInput(data());
				int packetId = UT.Code.unsignB(in.readByte());
				if (handler.mPacketTypes[packetId] == null) {
					// Version mismatch: server/client GT6 versions differ
					System.err.println("[GregTech] Received unknown packet ID " + packetId
						+ " on channel '" + channelId() + "' — version mismatch?");
					return;
				}
				IPacket packet = handler.mPacketTypes[packetId].decode(in);
				// PHASE3: pass ctx.player().level() instead of null for client-side world
				packet.process(null, handler);
			});
		}
	}

	/**
	 * Call this from the mod's RegisterPayloadHandlersEvent subscriber (once only).
	 * Example in GT_API:
	 *   {@code @SubscribeEvent}
	 *   {@code public static void onRegisterPayloads(RegisterPayloadHandlersEvent event) {}
	 *       NetworkHandler.registerPayloadHandlers(event);
	 *   }
	 */
	public static void registerPayloadHandlers(RegisterPayloadHandlersEvent event) {
		PayloadRegistrar registrar = event.registrar("1");
		registrar.playBidirectional(
			GregPacketPayload.TYPE,
			GregPacketPayload.STREAM_CODEC,
			(payload, ctx) -> payload.handle(ctx)
		);
	}

	// ---------------------------------------------------------------------------
	// Instance state
	// ---------------------------------------------------------------------------

	private final IPacket[] mPacketTypes;
	private final String mChannelId;

	/**
	 * @param aModID       the mod ID (e.g. "gregtech")
	 * @param aChannelName a short channel label (e.g. "GREG", "GAPI")
	 * @param aPacketTypes prototype instances of every packet type; getPacketID() must be unique per handler
	 */
	public NetworkHandler(String aModID, String aChannelName, IPacket... aPacketTypes) {
		mChannelId = aModID.toLowerCase() + ":" + aChannelName.toLowerCase();
		REGISTRY.put(mChannelId, this);
		mPacketTypes = new IPacket[256];
		for (IPacket pkt : aPacketTypes) {
			int id = UT.Code.unsignB(pkt.getPacketID());
			if (mPacketTypes[id] == null) mPacketTypes[id] = pkt;
			else throw new IllegalArgumentException("Duplicate Packet ID " + id + " on channel " + mChannelId);
		}
	}

	// ---------------------------------------------------------------------------
	// Internal encoding helper
	// ---------------------------------------------------------------------------

	private GregPacketPayload encode(IPacket aPacket) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (DataOutputStream dos = new DataOutputStream(baos)) {
			dos.writeByte(aPacket.getPacketID());
			dos.write(aPacket.encode().toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new GregPacketPayload(mChannelId, baos.toByteArray());
	}

	// ---------------------------------------------------------------------------
	// INetworkHandler implementation
	// ---------------------------------------------------------------------------

	@Override
	public void sendToServer(IPacket aPacket) {
		if (aPacket == null) return;
		PacketDistributor.sendToServer(encode(aPacket));
	}

	@Override
	public void sendToPlayer(IPacket aPacket, ServerPlayer aPlayer) {
		if (aPacket == null) return;
		PacketDistributor.sendToPlayer(aPlayer, encode(aPacket));
	}

	@Override
	public void sendToAllAround(IPacket aPacket, INetworkHandler.TargetPoint aPosition) {
		if (aPacket == null) return;
		if (!(aPosition.level() instanceof ServerLevel sl)) return;
		PacketDistributor.sendToPlayersNear(sl, null,
			aPosition.x(), aPosition.y(), aPosition.z(), aPosition.range(),
			encode(aPacket));
	}

	@Override
	public void sendToAllPlayersInRange(IPacket aPacket, Level aWorld, BlockPos aCoords) {
		sendToAllPlayersInRange(aPacket, aWorld, aCoords.getX(), aCoords.getZ());
	}

	@Override
	public void sendToAllPlayersInRange(IPacket aPacket, Level aWorld, int aX, int aZ) {
		if (aPacket == null || aWorld == null || aWorld.isClientSide()) return;
		GregPacketPayload payload = encode(aPacket);
		for (ServerPlayer tPlayer : ((ServerLevel) aWorld).players()) {
			// PHASE3: isPlayerWatchingChunk → PlayerChunkTracker / forceTickViewerOf
			if (tPlayer.chunkPosition().equals(
					new net.minecraft.world.level.ChunkPos(
							net.minecraft.core.SectionPos.blockToSectionCoord(aX),
							net.minecraft.core.SectionPos.blockToSectionCoord(aZ)))) {
				PacketDistributor.sendToPlayer(tPlayer, payload);
			}
		}
	}

	@Override
	public void sendToPlayerIfInRange(IPacket aPacket, UUID aPlayer, Level aWorld, BlockPos aCoords) {
		sendToPlayerIfInRange(aPacket, aPlayer, aWorld, aCoords.getX(), aCoords.getZ());
	}

	@Override
	public void sendToPlayerIfInRange(IPacket aPacket, UUID aPlayer, Level aWorld, int aX, int aZ) {
		if (aPacket == null || aWorld == null || aWorld.isClientSide()) return;
		net.minecraft.world.level.ChunkPos targetChunk = new net.minecraft.world.level.ChunkPos(
			net.minecraft.core.SectionPos.blockToSectionCoord(aX),
			net.minecraft.core.SectionPos.blockToSectionCoord(aZ));
		GregPacketPayload payload = encode(aPacket);
		for (ServerPlayer tPlayer : ((ServerLevel) aWorld).players()) {
			if (tPlayer.getUUID().equals(aPlayer) && tPlayer.chunkPosition().equals(targetChunk)) {
				PacketDistributor.sendToPlayer(tPlayer, payload);
				return;
			}
		}
	}

	@Override
	public void sendToAllPlayersInRangeExcept(IPacket aPacket, UUID aPlayer, Level aWorld, BlockPos aCoords) {
		sendToAllPlayersInRangeExcept(aPacket, aPlayer, aWorld, aCoords.getX(), aCoords.getZ());
	}

	@Override
	public void sendToAllPlayersInRangeExcept(IPacket aPacket, UUID aPlayer, Level aWorld, int aX, int aZ) {
		if (aPacket == null || aWorld == null || aWorld.isClientSide()) return;
		net.minecraft.world.level.ChunkPos targetChunk = new net.minecraft.world.level.ChunkPos(
			net.minecraft.core.SectionPos.blockToSectionCoord(aX),
			net.minecraft.core.SectionPos.blockToSectionCoord(aZ));
		GregPacketPayload payload = encode(aPacket);
		for (ServerPlayer tPlayer : ((ServerLevel) aWorld).players()) {
			if (!tPlayer.getUUID().equals(aPlayer) && tPlayer.chunkPosition().equals(targetChunk)) {
				PacketDistributor.sendToPlayer(tPlayer, payload);
			}
		}
	}
}
