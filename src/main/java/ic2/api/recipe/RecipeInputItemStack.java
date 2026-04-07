package ic2.api.recipe;
// PHASE8: stub for compat

import net.minecraft.world.item.ItemStack;
import java.util.Collection;
import java.util.Collections;
import gregapi.stubs.ic2.IRecipeInput;
public class RecipeInputItemStack implements IRecipeInput {
    public final ItemStack input;
    public RecipeInputItemStack(ItemStack input) { this.input = input; }
    public Collection<ItemStack> getInputs() { return Collections.singletonList(input); }
    public boolean matches(ItemStack stack) { return false; }
    public int getAmount() { return input == null ? 0 : input.getCount(); }
}
