package codechicken.nei;
// PHASE8: stub for compat

import net.minecraft.world.item.ItemStack;
import java.util.*;
public class PositionedStack {
    public ItemStack[] items;
    /** The currently displayed item (may be null or the first element of items) */
    public ItemStack item;
    public int x, y;
    public PositionedStack(Object object, int x, int y) { this(object, x, y, true); }
    public PositionedStack(Object object, int x, int y, boolean set) {
        this.x = x; this.y = y;
        if (object instanceof ItemStack) {
            items = new ItemStack[]{(ItemStack)object};
            item = (ItemStack)object;
        } else if (object instanceof List) {
            List<ItemStack> list = (List<ItemStack>)object;
            items = list.toArray(new ItemStack[0]);
            item = items.length > 0 ? items[0] : null;
        } else {
            items = new ItemStack[0];
            item = null;
        }
    }
    public void setPermutationToRender(int index) {
        if (items != null && index < items.length) item = items[index];
    }
    public void generatePermutations() {}
}
