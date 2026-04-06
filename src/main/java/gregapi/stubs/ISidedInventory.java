package gregapi.stubs;

import net.minecraft.core.Direction;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;

// PHASE3: net.minecraft.inventory.ISidedInventory → net.neoforged.neoforge.common.extensions.
// Stub for compilation. Real implementation deferred to Phase 3.
@SuppressWarnings("unused")
public interface ISidedInventory extends Container {
	int[] getSlotsForFace(Direction side);
	boolean canPlaceItemThroughFace(int index, ItemStack stack, Direction side);
	boolean canTakeItemThroughFace(int index, ItemStack stack, Direction side);
}
