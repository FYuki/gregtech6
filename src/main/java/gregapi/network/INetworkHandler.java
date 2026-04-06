/**
 * Copyright (c) 2019 Gregorius Techneticies
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

import java.util.UUID;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

/**
 * @author Gregorius Techneticies
 *
 * PHASE2: Updated to NeoForge 1.21.4 types.
 *   ServerPlayer → ServerPlayer
 *   BlockPos → BlockPos
 *   Level → Level
 *   TargetPoint moved to inner record
 *   FMLEmbeddedChannel removed
 */
public interface INetworkHandler {
	/** Positional target for area-broadcast packets. */
	record TargetPoint(Level level, double x, double y, double z, double range) {}

	/** It sends a Packet from Client to Server. */
	void sendToServer(IPacket aPacket);
	/** It sends a Packet to the Player, who is mentioned inside the Parameter. */
	void sendToPlayer(IPacket aPacket, ServerPlayer aPlayer);
	/** It sends a Packet to all Players in the specified range. */
	void sendToAllAround(IPacket aPacket, TargetPoint aPosition);
	/** It sends a Packet to all Players watching the LevelChunk at X/Z. */
	void sendToAllPlayersInRange(IPacket aPacket, Level aWorld, int aX, int aZ);
	/** It sends a Packet to all Players watching the LevelChunk at the BlockPos. */
	void sendToAllPlayersInRange(IPacket aPacket, Level aWorld, BlockPos aCoords);
	/** It sends a Packet to one Player (by UUID) if they watch the LevelChunk at X/Z. */
	void sendToPlayerIfInRange(IPacket aPacket, UUID aPlayer, Level aWorld, int aX, int aZ);
	/** It sends a Packet to one Player (by UUID) if they watch the LevelChunk at the BlockPos. */
	void sendToPlayerIfInRange(IPacket aPacket, UUID aPlayer, Level aWorld, BlockPos aCoords);
	/** It sends a Packet to all Players except one watching the LevelChunk at X/Z. */
	void sendToAllPlayersInRangeExcept(IPacket aPacket, UUID aPlayer, Level aWorld, int aX, int aZ);
	/** It sends a Packet to all Players except one watching the LevelChunk at the BlockPos. */
	void sendToAllPlayersInRangeExcept(IPacket aPacket, UUID aPlayer, Level aWorld, BlockPos aCoords);
}
