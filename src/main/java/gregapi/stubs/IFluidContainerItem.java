package gregapi.stubs;
// PHASE3: IFluidContainerItem replaced by IFluidHandlerItem in NeoForge 1.21
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
@SuppressWarnings("unused")
public interface IFluidContainerItem {
    FluidStack getFluid(ItemStack container);
    int getCapacity(ItemStack container);
    int fill(ItemStack container, FluidStack resource, boolean doFill);
    FluidStack drain(ItemStack container, int maxDrain, boolean doDrain);
}
