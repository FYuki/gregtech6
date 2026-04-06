package gregapi.stubs;
// PHASE3: ISpecialArmor replaced by ArmorItem capability model in NeoForge 1.21
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
@SuppressWarnings("unused")
public interface ISpecialArmor {
    double getDamageAbsorption(LivingEntity entity, ItemStack armor, net.minecraft.world.damagesource.DamageSource source, double damage, int slot);
    int getArmorDisplay(LivingEntity player, ItemStack armor, int slot);
    void damageArmor(LivingEntity entity, ItemStack stack, net.minecraft.world.damagesource.DamageSource source, int damage, int slot);
}
