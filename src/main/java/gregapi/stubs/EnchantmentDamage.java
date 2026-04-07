package gregapi.stubs;
// PHASE3: stub - EnchantmentDamage was removed/renamed in 1.21
// In 1.21, weapon damage enchantments use data-driven JSON definitions.
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public abstract class EnchantmentDamage extends Enchantment {
    // Enchantment types: 0=all, 1=undead, 2=arthropod
    public final int damageType;
    protected EnchantmentDamage(Rarity rarity, int damageType, EquipmentSlot... slots) {
        super(rarity, EnchantmentCategory.WEAPON, slots);
        this.damageType = damageType;
    }
}
