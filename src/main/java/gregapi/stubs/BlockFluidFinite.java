package gregapi.stubs;
// PHASE3: BlockFluidFinite replaced by BaseFlowingFluid in NeoForge 1.21
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
@SuppressWarnings("unused")
public class BlockFluidFinite extends LiquidBlock {
    public BlockFluidFinite(net.neoforged.neoforge.registries.DeferredHolder<net.minecraft.world.level.material.Fluid, ?> fluid, Properties props) {
        super(fluid, props);
    }
}
