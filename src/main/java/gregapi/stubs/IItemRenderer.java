package gregapi.stubs;
// PHASE4: IItemRenderer removed — use BakedModel in 1.21
import net.minecraft.world.item.ItemStack;
@SuppressWarnings("unused")
public interface IItemRenderer {
    boolean handleRenderType(ItemStack item, Object type);
    boolean shouldUseRenderHelper(Object type, ItemStack item, Object helper);
    void renderItem(Object type, ItemStack item, Object renderHelper);
}
