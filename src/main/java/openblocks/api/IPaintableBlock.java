package openblocks.api;
// PHASE8: stub for compat
import net.minecraft.world.level.block.state.BlockState; import net.minecraft.core.BlockPos; public interface IPaintableBlock { boolean recolourBlock(net.minecraft.world.level.Level world, BlockPos pos, net.minecraft.core.Direction side, net.minecraft.world.item.DyeColor colour); }
