package codechicken.nei.recipe;
// PHASE8: stub for compat

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.CachedRecipe;
import codechicken.nei.recipe.RecipeTransferRect;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
public abstract class TemplateRecipeHandler {
    public List<RecipeTransferRect> transferRects = new ArrayList<>();
    public int cycleticks = 0;
    public abstract TemplateRecipeHandler newInstance();
    public String getOverlayIdentifier() { return ""; }
    public String getRecipeName() { return ""; }
    protected List<PositionedStack> getCycledIngredients(int cycle, List<PositionedStack> ingredients) {
        if (ingredients.isEmpty()) return ingredients;
        return ingredients;
    }
    public List<CachedRecipe> arecipes = new ArrayList<>();
    public void loadCraftingRecipes(net.minecraft.world.item.ItemStack result) {}
    public void loadUsageRecipes(net.minecraft.world.item.ItemStack ingredient) {}
    public int recipiesPerPage() { return 2; }
    public String getGuiTexture() { return ""; }
}
