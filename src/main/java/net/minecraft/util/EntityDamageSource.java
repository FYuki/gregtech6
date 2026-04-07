package net.minecraft.util;
// PHASE3: stub - EntityDamageSource (MC 1.7.10) abstracted for compilation
// In 1.21, replaced by DamageSource with DamageType registry key
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class EntityDamageSource {
    public final String msgId;
    protected final Entity entity;

    public EntityDamageSource(String msgId, Entity entity) {
        this.msgId = msgId;
        this.entity = entity;
    }

    public Entity getDirectEntity() { return entity; }
    public Entity getEntity() { return entity; }

    public Component func_151519_b(LivingEntity target) {
        return Component.literal(entity.getName().getString() + " killed " + target.getName().getString());
    }
}
