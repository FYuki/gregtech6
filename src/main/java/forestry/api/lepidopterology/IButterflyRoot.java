package forestry.api.lepidopterology;
// PHASE8: stub for compat
import java.util.List; import net.minecraft.world.item.ItemStack; public interface IButterflyRoot { Object getIndividual(ItemStack stack); List<ItemStack> getAlyzerProducts(Object butterfly, float[] chances); }
