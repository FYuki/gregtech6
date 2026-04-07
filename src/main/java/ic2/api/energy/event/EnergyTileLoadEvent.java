package ic2.api.energy.event;
// PHASE8: stub for compat

import ic2.api.energy.tile.IEnergyTile;
import net.neoforged.bus.api.Event;
public class EnergyTileLoadEvent extends Event {
    public final IEnergyTile source;
    public EnergyTileLoadEvent(IEnergyTile source) { this.source = source; }
}
