package ic2.api.recipe;
// PHASE8: stub for compat

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import gregapi.stubs.ic2.IRecipeInput;
public interface IMachineRecipeManagerExt extends gregapi.stubs.ic2.IMachineRecipeManager {
    void addRecipe(IRecipeInput input, CompoundTag metadata, boolean useOreDict, ItemStack... outputs);
}
