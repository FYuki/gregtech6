package micdoodle8.mods.galacticraft.api.item;
// PHASE8: Galacticraft IItemElectric stub
public interface IItemElectric {
    float getElectricityStored(net.minecraft.world.item.ItemStack stack);
    float getMaxElectricityStored(net.minecraft.world.item.ItemStack stack);
    net.minecraft.world.item.ItemStack setElectricity(net.minecraft.world.item.ItemStack stack, float electricity);
    float getTransfer(net.minecraft.world.item.ItemStack stack);
    net.minecraft.world.item.ItemStack getEmpty();
}
