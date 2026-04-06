package gregapi.stubs;
// PHASE3: ItemExpireEvent stub
import net.neoforged.bus.api.Event;
import net.minecraft.world.entity.item.ItemEntity;
@SuppressWarnings("unused")
public class ItemExpireEvent extends Event {
    public final ItemEntity entityItem;
    public ItemExpireEvent(ItemEntity entity) { this.entityItem = entity; }
}
