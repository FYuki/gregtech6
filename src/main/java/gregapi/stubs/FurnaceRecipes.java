package gregapi.stubs;
// PHASE7: FurnaceRecipes replaced by RecipeType.SMELTING in 1.21
import net.minecraft.world.item.ItemStack;
@SuppressWarnings("unused")
public class FurnaceRecipes {
    public static FurnaceRecipes smelting() { return new FurnaceRecipes(); }
    public ItemStack getSmeltingResult(ItemStack input) { return ItemStack.EMPTY; }
    public float getSmeltingExperience(ItemStack stack) { return 0; }
}
