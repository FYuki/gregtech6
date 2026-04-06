package gregapi.stubs;

import net.minecraft.world.item.ItemStack;

// PHASE7: CraftingManager replaced by RecipeManager in 1.21.
// Stub for compilation.
@SuppressWarnings("unused")
public class CraftingManager {
	public static CraftingManager getInstance() { return new CraftingManager(); }
	public java.util.List<net.minecraft.world.item.crafting.Recipe<?>> getRecipeList() { return java.util.Collections.emptyList(); }
	public void addRecipe(ItemStack output, Object... params) {}
	public void addShapelessRecipe(ItemStack output, Object... params) {}
}
