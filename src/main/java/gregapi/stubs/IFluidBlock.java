package gregapi.stubs;
// PHASE3: IFluidBlock replaced by FluidBlock/LiquidBlock in NeoForge 1.21
import net.neoforged.neoforge.fluids.FluidStack;
@SuppressWarnings("unused")
public interface IFluidBlock {
    FluidStack drain(net.minecraft.world.level.Level world, net.minecraft.core.BlockPos pos, net.neoforged.neoforge.fluids.capability.IFluidHandler.FluidAction action);
    boolean canDrain(net.minecraft.world.level.Level world, net.minecraft.core.BlockPos pos);
    float getFilledPercentage(net.minecraft.world.level.Level world, net.minecraft.core.BlockPos pos);
}
