package gregapi.stubs.ic2;
// PHASE8: stub for compat — replace with real API when mod is present

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
public class RecipeOutput {
    public final CompoundTag metadata;
    public final ItemStack[] items;
    public RecipeOutput(CompoundTag metadata, ItemStack... items) {
        this.metadata = metadata;
        this.items = items;
    }
}
