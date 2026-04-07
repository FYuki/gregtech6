package codechicken.nei.recipe;
// PHASE8: stub for compat

import codechicken.nei.PositionedStack;
import java.util.List;
public abstract class CachedRecipe {
    public abstract List<PositionedStack> getIngredients();
    public abstract PositionedStack getResult();
    public List<PositionedStack> getOtherStacks() { return new java.util.ArrayList<>(); }
    public List<PositionedStack> getCycledIngredients(int cycle, List<PositionedStack> ingredients) {
        return ingredients;
    }
}
