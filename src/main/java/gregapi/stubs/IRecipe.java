package gregapi.stubs;

// PHASE7: IRecipe renamed to Recipe<C extends RecipeInput> in 1.21.
// Stub interface keeps ICraftingRecipeGT and related classes compiling.
// Real implementation deferred to Phase 7 (recipe system rewrite).
import net.minecraft.world.item.ItemStack;
@SuppressWarnings("unused")
public interface IRecipe {
    boolean matches(Object grid, Object world);
    ItemStack getCraftingResult(Object grid);
    ItemStack getRecipeOutput();
    java.util.List<net.minecraft.core.NonNullList<ItemStack>> getRemainingItems(Object grid);
}
