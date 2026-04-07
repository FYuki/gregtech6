package net.neoforged.neoforge.event.entity.player;
// PHASE8: stub - UseHoeEvent was removed in NeoForge 21.4.x
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;

public class UseHoeEvent extends Event {
    private final Level world;
    private final Player player;
    private final ItemStack current;
    private final int x, y, z;
    private net.minecraft.world.item.crafting.SingleRecipeInput result;

    public UseHoeEvent(Player player, ItemStack current, Level world, int x, int y, int z) {
        this.player = player; this.current = current;
        this.world = world; this.x = x; this.y = y; this.z = z;
    }
    public Level getWorld() { return world; }
    public Player getPlayer() { return player; }
    public ItemStack getCurrent() { return current; }
    public net.minecraft.world.item.crafting.SingleRecipeInput getResult() { return result; }
    public void setResult(net.minecraft.world.item.crafting.SingleRecipeInput r) { this.result = r; }
}
