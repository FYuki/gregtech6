package ic2.api.recipe;
// PHASE8: stub for compat

import net.minecraft.world.item.ItemStack;
import java.util.Collection;
import java.util.Collections;
import gregapi.stubs.ic2.IRecipeInput;
public class RecipeInputOreDict implements IRecipeInput {
    public final String oreName;
    public final int amount;
    public RecipeInputOreDict(String oreName, int amount) { this.oreName = oreName; this.amount = amount; }
    public Collection<ItemStack> getInputs() { return Collections.emptyList(); }
    public boolean matches(ItemStack stack) { return false; }
    public int getAmount() { return amount; }
}
