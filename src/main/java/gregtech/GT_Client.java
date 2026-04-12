/**
 * Copyright (c) 2025 GregTech-6 Team
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

package gregtech;

import gregapi.stubs.RenderingRegistry;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import gregapi.GT_API;
import gregapi.api.Abstract_Mod;
import gregapi.config.ConfigCategories;
import gregapi.data.LH;
import gregapi.data.MD;
import gregtech.entities.projectiles.EntityArrow_Material;
import gregtech.entities.projectiles.EntityArrow_Potion;
import gregtech.render.GT_Renderer_Entity_Arrow;
import gregtech.render.PlayerModelRenderer;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Component;
import gregapi.stubs.RenderBlockOverlayEvent;
import gregapi.stubs.RenderPlayerEvent;

import static gregapi.data.CS.*;

public class GT_Client extends GT_Proxy {
	private final PlayerModelRenderer mPlayerRenderer = new PlayerModelRenderer(mSupporterListSilver, mSupporterListGold);
	
	public int addArmor(String aPrefix) {return RenderingRegistry.addNewArmourRendererPrefix(aPrefix);}
	
	public GT_Client() {super();}
	
	@Override
	public void onProxyAfterPreInit(Abstract_Mod aMod, FMLCommonSetupEvent aEvent) {
		super.onProxyAfterPreInit(aMod, aEvent);
		new GT_Renderer_Entity_Arrow(EntityArrow_Material.class, "arrow");
		new GT_Renderer_Entity_Arrow(EntityArrow_Potion.class, "arrow_potions");
	}

	private boolean FIRST_CLIENT_PLAYER_TICK = T;

	@SubscribeEvent
	public void onPlayerTickEventClient(PlayerTickEvent.Post aEvent) {
		// PHASE2: PlayerTickEvent.Post replaces PlayerTickEvent with phase==END check; side is always client here
		if (aEvent.getEntity().isAlive() && CLIENT_TIME > 20) {
			if (aEvent.getEntity() == GT_API.api_proxy.getThePlayer()) {
				if (FIRST_CLIENT_PLAYER_TICK) {
					FIRST_CLIENT_PLAYER_TICK = F;
					MutableComponent tLink;
					if (!mMessage.isEmpty() && ConfigsGT.CLIENT.get(ConfigCategories.news, mMessage, T)) {
						aEvent.getEntity().sendSystemMessage(Component.literal(mMessage));
						aEvent.getEntity().sendSystemMessage(Component.literal(LH.Chat.DGRAY + ""));
						tLink = Component.literal(LH.Chat.DGRAY + "disable message in the clientside gregtech.cfg");
						tLink = tLink.withStyle(s -> s.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, ConfigsGT.CLIENT.mConfig.getConfigFile().getAbsolutePath())));
						aEvent.getEntity().sendSystemMessage(tLink);
					}
					if (mVersionOutdated) {
						aEvent.getEntity().sendSystemMessage(Component.literal("Major GT6 Update released, for details visit"));
						tLink = Component.literal(LH.Chat.BLUE + "https://gregtech.mechaenetia.com/1.7.10");
						tLink = tLink.withStyle(s -> s.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://gregtech.mechaenetia.com/1.7.10")));
						aEvent.getEntity().sendSystemMessage(tLink);
						tLink = Component.literal(LH.Chat.DGRAY + "disable checker in the clientside gregtech.cfg");
						tLink = tLink.withStyle(s -> s.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, ConfigsGT.CLIENT.mConfig.getConfigFile().getAbsolutePath())));
						aEvent.getEntity().sendSystemMessage(tLink);
					}
					if (MD.IC2.mLoaded && !MD.IC2C.mLoaded) {
						try {
							int tVersion = Integer.parseInt(((String)Class.forName("ic2.core.IC2").getField("VERSION").get(null)).substring(4, 7));
							if (tVersion < 827) {
								aEvent.getEntity().sendSystemMessage(Component.literal(LH.Chat.RED + "Please update IndustrialCraft!"));
								// IC2 Site doesn't support https.
								tLink = Component.literal(LH.Chat.BLUE + "http://ic2api.player.to:8080/job/IC2_experimental/827/");
								tLink = tLink.withStyle(s -> s.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://ic2api.player.to:8080/job/IC2_experimental/827/")));
								aEvent.getEntity().sendSystemMessage(tLink);
							}
						} catch(Throwable e) {/**/}
					}
					if (MD.TC.mLoaded) {
						try {
							if (Class.forName("com.chocohead.patcher.ThaumicFixer") != null) {
								aEvent.getEntity().sendSystemMessage(Component.literal(LH.Chat.RED + "Warning! Chocoheads ThaumicFixer needs to be uninstalled!"));
								aEvent.getEntity().sendSystemMessage(Component.literal(LH.Chat.ORANGE + "Not uninstalling it can lead to crashes when viewing Aspects."));
								aEvent.getEntity().sendSystemMessage(Component.literal(LH.Chat.ORANGE + "Lag is already fixed with a better Version of the ASM Code,"));
								aEvent.getEntity().sendSystemMessage(Component.literal(LH.Chat.ORANGE + "that doesn't obliterate the Thaumcraft API for no reason."));
							}
						} catch(Throwable e) {/**/}
					}
					if (MD.COG.mLoaded && !MD.PFAA.mLoaded && ConfigsGT.CLIENT.get(ConfigCategories.general, "warnings_customoregen", T)) {
						aEvent.getEntity().sendSystemMessage(Component.literal(LH.Chat.RED + "Warning! CustomOreGen will screw up all GregTech Worldgen with its Default Configs!"));
						aEvent.getEntity().sendSystemMessage(Component.literal(LH.Chat.ORANGE + "If you don't even use CustomOreGen, I would highly recommend you to remove it."));
						tLink = Component.literal(LH.Chat.DGRAY + "disable warning in the clientside gregtech.cfg");
						tLink = tLink.withStyle(s -> s.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, ConfigsGT.CLIENT.mConfig.getConfigFile().getAbsolutePath())));
						aEvent.getEntity().sendSystemMessage(tLink);
					}
					if (WOODMANS_BDAY) {
						aEvent.getEntity().sendSystemMessage(Component.literal(LH.Chat.WHITE+"<"+LH.Chat.GREEN+">:]"+LH.Chat.WHITE+"> Have a nice day!"));
					}
					if (APRIL_FOOLS) {
						aEvent.getEntity().sendSystemMessage(Component.literal(CHAT_GREG + "Watch your Calendar!"));
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void receiveRenderEvent(RenderBlockOverlayEvent aEvent) {
		// PHASE4: swamp overlay rendering — Tessellator/GL11 removed in 1.21, rewrite with PoseStack/VertexConsumer
	}
	
	@SubscribeEvent
	public void receiveRenderEvent(RenderPlayerEvent.Pre aEvent) {
//      if (UT.Entities.getFullInvisibility(aEvent.entityPlayer)) {aEvent.setCanceled(true); return;}
	}
	
	@SubscribeEvent
	public void receiveRenderSpecialsEvent(RenderPlayerEvent.Specials.Pre aEvent) {
		mPlayerRenderer.receiveRenderSpecialsEvent(aEvent);
	}
	/*
	@Override
	public void doSonictronSound(ItemStack aStack, Level aWorld, double aX, double aY, double aZ) {
		if (UT.Stacks.invalid(aStack)) return;
		String tString = "note.harp";
		for (int i = 0, j = mSoundItems.size(); i < j; i++) if (UT.Stacks.equal(mSoundItems.get(i), aStack)) {tString = mSoundNames.get(i); break;}
		if (tString.startsWith("random.explode")) if (aStack.getCount()==3) tString = "random.fuse"; else if (aStack.getCount()==2) tString = "random.old_explode";
		if (tString.startsWith("streaming.")) {
			switch (aStack.getCount()) {
			case  1: tString += "13"; break;
			case  2: tString += "cat"; break;
			case  3: tString += "blocks"; break;
			case  4: tString += "chirp"; break;
			case  5: tString += "far"; break;
			case  6: tString += "mall"; break;
			case  7: tString += "mellohi"; break;
			case  8: tString += "stal"; break;
			case  9: tString += "strad"; break;
			case 10: tString += "ward"; break;
			case 11: tString += "11"; break;
			case 12: tString += "wait"; break;
			default: tString += "wherearewenow"; break;
			}
		}
		if (tString.startsWith("streaming.")) aWorld.playRecord(tString.substring(10, tString.length()), (int)aX, (int)aY, (int)aZ); else aWorld.playSound(aX, aY, aZ, tString, 3.0F, tString.startsWith("note.")?(float)Math.pow(2.0D, (aStack.getCount() - 13) / 12.0D):1.0F, false);
	}*/
	
}
