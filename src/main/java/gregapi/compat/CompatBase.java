/**
 * Copyright (c) 2023 GregTech-6 Team
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

package gregapi.compat;

import gregapi.stubs.FMLModIdMappingEvent;
import gregapi.stubs.MissingMappingsEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;

public abstract class CompatBase implements ICompat {
	@Override public void onPreLoad       (FMLCommonSetupEvent aEvent)   {/**/}
	@Override public void onLoad          (InterModEnqueueEvent aEvent)  {/**/}
	@Override public void onPostLoad      (FMLLoadCompleteEvent aEvent)  {/**/}
	@Override public void onServerStarting(ServerStartingEvent aEvent)   {/**/}
	@Override public void onServerStarted (ServerStartedEvent aEvent)    {/**/}
	@Override public void onServerStopping(ServerStoppingEvent aEvent)   {/**/}
	@Override public void onServerStopped (ServerStoppedEvent aEvent)    {/**/}
	/** @deprecated PHASE7: onIDChanging stubbed — MissingMappingsEvent removed in NeoForge 1.21 */
	@Override @Deprecated public void onIDChanging(MissingMappingsEvent<?> aEvent) {/**/}
}
