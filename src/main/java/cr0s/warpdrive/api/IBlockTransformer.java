package cr0s.warpdrive.api;
// PHASE8: stub for compat
public interface IBlockTransformer { boolean isApplicable(net.minecraft.world.level.block.state.BlockState state, net.minecraft.world.level.block.entity.BlockEntity be); boolean isJumpReady(net.minecraft.world.level.block.state.BlockState state, net.minecraft.world.level.block.entity.BlockEntity be, net.minecraft.world.level.Level world, net.minecraft.core.BlockPos pos, Object reason); net.minecraft.world.level.block.state.BlockState transformState(net.minecraft.world.level.block.state.BlockState state, ITransformation transformation); }
