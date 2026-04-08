package gregapi.stubs;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
/** PHASE3: stub — BlockStaticLiquid replaced by LiquidBlock in MC 1.13+ */
public class BlockStaticLiquid extends LiquidBlock {
    public BlockStaticLiquid(FlowingFluid fluid, Properties props) { super(fluid, props); }
}
