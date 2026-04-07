package cofh.api.energy;
// PHASE8: stub for compat
public interface IEnergyHandler { int receiveEnergy(net.minecraft.core.Direction from, int maxReceive, boolean simulate); int extractEnergy(net.minecraft.core.Direction from, int maxExtract, boolean simulate); int getEnergyStored(net.minecraft.core.Direction from); int getMaxEnergyStored(net.minecraft.core.Direction from); boolean canConnectEnergy(net.minecraft.core.Direction from); }
