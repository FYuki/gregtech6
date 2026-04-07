package gregapi.stubs;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

/** PHASE3: stub — NeoForge 1.21.4 renamed/reorganised item pickup events */
public class EntityItemPickupEvent extends PlayerEvent {
    public ItemEntity pickedUp;
    public ItemEntity entityItem;
    public int extraLife = 0;

    public Player player;

    public EntityItemPickupEvent(Player player, ItemEntity item) {
        super(player);
        this.player = player;
        this.pickedUp = item;
        this.entityItem = item;
    }
}
