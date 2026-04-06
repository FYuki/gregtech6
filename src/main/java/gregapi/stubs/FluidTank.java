package gregapi.stubs;
// PHASE3: FluidTank moved/refactored in NeoForge 1.21.
// Minimal stub so ZL_FLUIDTANK[] arrays compile. Real implementation: Phase 3.
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import gregapi.stubs.IFluidTank; // stub
@SuppressWarnings("unused")
public class FluidTank implements IFluidTank {
    protected FluidStack fluid = FluidStack.EMPTY;
    protected int capacity;
    public FluidTank(int capacity) { this.capacity = capacity; }
    @Override public FluidStack getFluid() { return fluid; }
    @Override public int getFluidAmount() { return fluid.isEmpty() ? 0 : fluid.getAmount(); }
    @Override public int getCapacity() { return capacity; }
    @Override public FluidStack drain(int maxDrain, IFluidHandler.FluidAction action) { return FluidStack.EMPTY; }
    @Override public int fill(FluidStack resource, IFluidHandler.FluidAction action) { return 0; }
}
