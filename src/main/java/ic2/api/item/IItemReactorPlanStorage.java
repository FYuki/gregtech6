package ic2.api.item;
import net.minecraft.world.item.ItemStack;
/** PHASE8: stub — IC2 reactor plan storage API */
public interface IItemReactorPlanStorage {
    boolean canStoreReactorPlan(ItemStack stack);
    int[] getReactorPlan(ItemStack stack);
    void setReactorPlan(ItemStack stack, int[] plan);
}
