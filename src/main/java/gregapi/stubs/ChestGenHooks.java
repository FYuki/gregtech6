package gregapi.stubs;
// PHASE7: ChestGenHooks removed — use LootTables in 1.21
import net.minecraft.world.item.ItemStack;
@SuppressWarnings("unused")
public class ChestGenHooks {
    public static ChestGenHooks getInfo(String category) { return new ChestGenHooks(); }
    public void addItem(ItemStack item, int min, int max, int weight) {}
    public void removeItem(Class<?> itemClass, int meta) {}
}
