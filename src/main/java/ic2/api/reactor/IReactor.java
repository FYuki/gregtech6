package ic2.api.reactor;
// PHASE8: stub for compat
import net.minecraft.world.item.ItemStack; public interface IReactor { int getHeat(); int getMaxHeat(); double getEnergyOutput(); ItemStack getItemAt(int row, int col); void setItemAt(int row, int col, ItemStack stack); }
