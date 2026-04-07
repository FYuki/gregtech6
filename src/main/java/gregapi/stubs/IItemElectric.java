package gregapi.stubs;
// PHASE8: stub for Galacticraft IItemElectric
import net.minecraft.world.item.ItemStack;
public interface IItemElectric {
    float getElectricityStored(ItemStack stack);
    float getMaxElectricityStored(ItemStack stack);
    ItemStack setElectricity(ItemStack stack, float electricity);
    float getTransfer(ItemStack stack);
    ItemStack getEmpty();
}
