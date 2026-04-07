package net.minecraft.util;
// PHASE7: stub - WeightedRandomChestContent replaced by LootTable system in 1.21
import net.minecraft.world.item.ItemStack;
public class WeightedRandomChestContent {
    public final ItemStack theItemId;
    public final int minStackSize, maxStackSize, itemWeight;
    public WeightedRandomChestContent(ItemStack stack, int min, int max, int weight) {
        this.theItemId = stack; this.minStackSize = min; this.maxStackSize = max; this.itemWeight = weight;
    }
    public ItemStack getItemStack() { return theItemId; }
}
