package ic2.api.energy.event;
// PHASE8: stub for compat

import ic2.api.energy.tile.IEnergyTile;
import net.neoforged.bus.api.Event;
public class EnergyTileUnloadEvent extends Event {
    public final IEnergyTile source;
    public EnergyTileUnloadEvent(IEnergyTile source) { this.source = source; }
}
