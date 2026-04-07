package vazkii.botania.api.mana;
// PHASE8: stub for compat
import net.minecraft.world.level.Level;
public interface IManaTrigger {
    void onBurstCollision(vazkii.botania.api.internal.IManaBurst burst, Level world, int x, int y, int z);
}
