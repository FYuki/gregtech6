package gregapi.stubs;
import gregapi.stubs.HarvestDropsEvent;
// PHASE7: HarvestDropsEvent removed in NeoForge 1.21 — loot tables handle drops now.
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import java.util.List;
@Deprecated
public class HarvestDropsEvent {
    public Player getHarvester() { return null; }
    public List<ItemStack> getDrops() { return new java.util.ArrayList<>(); }
    public float getDropChance() { return 1.0f; }
    public int getFortuneLevel() { return 0; }
    public boolean isSilkTouching() { return false; }
}
