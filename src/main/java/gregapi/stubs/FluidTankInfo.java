package gregapi.stubs;

import net.neoforged.neoforge.fluids.FluidStack;
@SuppressWarnings("unused")
public class FluidTankInfo {
	public final FluidStack fluid;
	public final int capacity;

	public FluidTankInfo(FluidStack fluid, int capacity) {
		this.fluid = fluid;
		this.capacity = capacity;
	}
}
