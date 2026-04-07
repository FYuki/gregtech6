package gregapi.stubs.ic2;
// PHASE8: stub for compat — replace with real API when mod is present

import net.minecraft.world.item.ItemStack;
import java.util.Collection;
public interface IRecipeInput {
    Collection<ItemStack> getInputs();
    boolean matches(ItemStack stack);
    int getAmount();
}
