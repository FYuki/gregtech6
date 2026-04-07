package gregapi.stubs;
// PHASE3: stub - EnchantmentDamage was removed; Enchantment is now a record in 1.21
// This stub provides compilation compat without extending Enchantment.
import net.minecraft.world.entity.EquipmentSlot;

public abstract class EnchantmentDamage {
    public static final int ALL = 0, UNDEAD = 1, ARTHROPOD = 2;
    public final int damageType;
    protected EnchantmentDamage(Object rarity, int damageType, EquipmentSlot... slots) {
        this.damageType = damageType;
    }
    public int getMinCost(int level) { return 1 + level * 10; }
    public int getMaxCost(int level) { return getMinCost(level) + 5; }
    public int getMaxLevel() { return 5; }
}
