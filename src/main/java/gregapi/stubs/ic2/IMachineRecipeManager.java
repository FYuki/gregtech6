package gregapi.stubs.ic2;
// PHASE8: stub for compat — replace with real API when mod is present

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import gregapi.stubs.ic2.IRecipeInput;
import gregapi.stubs.ic2.RecipeOutput;
import java.util.Map;
public interface IMachineRecipeManager {
    void addRecipe(IRecipeInput input, CompoundTag metadata, ItemStack... outputs);
    Map<IRecipeInput, RecipeOutput> getRecipes();
}
