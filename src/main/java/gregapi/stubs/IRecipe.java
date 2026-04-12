package gregapi.stubs;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
// PHASE7: IRecipe renamed to Recipe<C extends RecipeInput> in 1.21.
@SuppressWarnings("unused")
public interface IRecipe {
    boolean matches(CraftingContainer grid, Level world);
    ItemStack getCraftingResult(CraftingContainer grid);
    ItemStack getRecipeOutput();
    default java.util.List<net.minecraft.core.NonNullList<ItemStack>> getRemainingItems(CraftingContainer grid) { return java.util.Collections.emptyList(); }
}
