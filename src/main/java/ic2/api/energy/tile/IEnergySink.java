package ic2.api.energy.tile;
// PHASE8: stub for compat
public interface IEnergySink extends IEnergyTile { double getDemandedEnergy(); int getSinkTier(); double injectEnergy(Object directionFrom, double amount, double voltage); }
