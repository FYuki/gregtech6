package gregapi.stubs;
// PHASE3: GameRegistry removed from NeoForge 1.21 — use DeferredRegister<Item>/<Block> + FuelRatioHandler
// This stub keeps ST.java, ItemFluidDisplay, PrefixItem, and other GT6 utils compiling during Phase 2.
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unused")
public class GameRegistry {
    /** PHASE3: Use DeferredRegister<Item> instead. */
    public static void registerItem(Item item, String name) { /* PHASE3: no-op */ }
    /** PHASE3: Use DeferredRegister<Item> instead. */
    public static void registerItem(Item item, String name, String modID) { /* PHASE3: no-op */ }

    /** PHASE3: Use DeferredRegister<Block> instead. */
    public static void registerBlock(Block block, String name) { /* PHASE3: no-op */ }
    /** PHASE3: Use DeferredRegister<Block> instead. */
    public static <T extends net.minecraft.world.item.BlockItem> void registerBlock(Block block, Class<T> itemClass, String name) { /* PHASE3: no-op */ }

    /** PHASE3: Use BuiltInRegistries.ITEM.get(ResourceLocation) instead. */
    public static Item findItem(String modID, String name) { return null; }

    /** PHASE3: Use BuiltInRegistries.ITEM.get(ResourceLocation) then make stack. */
    public static ItemStack findItemStack(String modID, String name, int size) { return null; }

    /** PHASE3: Use FuelRatioHandler (IFuelHandler) instead. */
    public static long getFuelValue(ItemStack stack) { return 0L; }
}
