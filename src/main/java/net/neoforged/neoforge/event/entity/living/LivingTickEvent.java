package net.neoforged.neoforge.event.entity.living;
// PHASE8: stub - In NeoForge 1.21.4, LivingEvent.Tick was renamed to LivingTickEvent
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
public class LivingTickEvent extends LivingEvent {
    public LivingTickEvent(LivingEntity entity) { super(entity); }
}
