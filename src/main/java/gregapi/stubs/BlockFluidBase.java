package gregapi.stubs;
// PHASE3: BlockFluidBase replaced by FlowingFluidBlock in NeoForge 1.21
import net.minecraft.world.level.material.Fluid;
@SuppressWarnings("unused")
public abstract class BlockFluidBase extends net.minecraft.world.level.block.Block {
    public BlockFluidBase(net.neoforged.neoforge.registries.DeferredHolder<net.minecraft.world.level.material.Fluid,?> fluid, Properties p) { super(p); }
}
