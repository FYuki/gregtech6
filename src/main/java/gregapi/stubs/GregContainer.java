package gregapi.stubs;
// PHASE3: wrapper around AbstractContainerMenu for old Container API compatibility
import net.minecraft.world.inventory.AbstractContainerMenu;

public abstract class GregContainer extends AbstractContainerMenu {
    protected GregContainer() {
        super(null, 0);
    }
    @Override
    public boolean stillValid(net.minecraft.world.entity.player.Player player) {
        return true;
    }
}
