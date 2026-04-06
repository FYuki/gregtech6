package gregapi.stubs;
// PHASE3: ForgeHooks partially replaced; stub for compilation
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
@SuppressWarnings("unused")
public class ForgeHooks {
    public static boolean canHarvestBlock(net.minecraft.world.level.block.Block block, Player player, net.minecraft.world.level.LevelReader level, net.minecraft.core.BlockPos pos) { return true; }
}
