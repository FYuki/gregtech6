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

import gregapi.code.ArrayListNoNulls;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
// PHASE7: MissingMappingsEvent removed in NeoForge 1.21 — numeric ID mapping no longer needed

import java.util.Collection;


public interface ICompat {
	public static final Collection<ICompat> COMPAT_CLASSES = new ArrayListNoNulls<>();

	public void onPreLoad       (FMLCommonSetupEvent aEvent);
	public void onLoad          (InterModEnqueueEvent aEvent);
	public void onPostLoad      (FMLLoadCompleteEvent aEvent);
	public void onServerStarting(ServerStartingEvent aEvent);
	public void onServerStarted (ServerStartedEvent aEvent);
	public void onServerStopping(ServerStoppingEvent aEvent);
	public void onServerStopped (ServerStoppedEvent aEvent);
	/** @deprecated PHASE7: Registry remapping - use MissingMappingsEvent per registry type */
	public void onIDChanging    (MissingMappingsEvent<?> aEvent);
}
