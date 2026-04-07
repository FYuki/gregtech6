package forestry.api.recipes;
// PHASE8: stub for compat
import net.minecraft.world.item.ItemStack; import java.util.List; public interface ISqueezerRecipe { List<ItemStack> getResources(); Object getFluidOutput(); ItemStack getRemnants(); float getRemnantsChance(); int getProcessingTime(); }
