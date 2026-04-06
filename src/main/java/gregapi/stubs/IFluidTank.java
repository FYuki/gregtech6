package gregapi.stubs;
// PHASE3: IFluidTank removed from NeoForge 1.21 — use IFluidHandler instead.
// Stub keeps GT6 FluidTankGT compiling during Phase 2.
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
@SuppressWarnings("unused")
public interface IFluidTank {
    FluidStack getFluid();
    int getFluidAmount();
    int getCapacity();
    FluidStack drain(int maxDrain, IFluidHandler.FluidAction action);
    int fill(FluidStack resource, IFluidHandler.FluidAction action);
}
