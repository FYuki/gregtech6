package gregapi.stubs;
// PHASE3: FluidContainerRegistry removed — use FluidUtil and IFluidHandlerItem in NeoForge 1.21
import net.neoforged.neoforge.fluids.FluidStack;
import net.minecraft.world.item.ItemStack;
@SuppressWarnings("unused")
public class FluidContainerRegistry {
    public static class FluidContainerRegisterEvent {
        public final FluidContainerData data;
        public FluidContainerRegisterEvent(FluidContainerData data) { this.data = data; }
    }

    public static class FluidContainerData {
        public final FluidStack fluid;
        public final ItemStack filledContainer;
        public final ItemStack emptyContainer;
        public FluidContainerData(FluidStack fluid, ItemStack filled, ItemStack empty) {
            this.fluid = fluid; this.filledContainer = filled; this.emptyContainer = empty;
        }
    }
    public static boolean registerFluidContainer(FluidContainerData data) { return false; }
    public static boolean registerFluidContainer(FluidStack fluid, ItemStack filled, ItemStack empty) { return false; }
    public static FluidStack getFluidForFilledItem(ItemStack item) { return null; }
    public static ItemStack fillFluidContainer(FluidStack fluid, ItemStack empty) { return null; }
}
