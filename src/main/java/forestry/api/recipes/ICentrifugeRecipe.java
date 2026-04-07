package forestry.api.recipes;
// PHASE8: stub for compat
import net.minecraft.world.item.ItemStack; import java.util.Map; public interface ICentrifugeRecipe { ItemStack getInput(); Map<ItemStack, Float> getProducts(); int getProcessingTime(); }
