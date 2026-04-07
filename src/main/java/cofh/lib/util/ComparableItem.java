package cofh.lib.util;
// PHASE8: stub for compat
import net.minecraft.world.item.Item; public class ComparableItem implements Comparable<ComparableItem> { public final Item item; public final int meta; public ComparableItem(Item item, int meta) { this.item=item; this.meta=meta; } public int compareTo(ComparableItem o) { return 0; } }
