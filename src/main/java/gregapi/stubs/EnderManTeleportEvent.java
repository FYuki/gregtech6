package gregapi.stubs;
// PHASE2: stub — EnderManTeleportEvent removed from NeoForge 1.21
import net.neoforged.bus.api.Cancelable;
import net.neoforged.bus.api.Event;
import net.minecraft.world.entity.Entity;
@Cancelable
@SuppressWarnings("unused")
public class EnderManTeleportEvent extends Event {
    public Entity getEntity() { return null; }
    public double getTargetX() { return 0; }
    public double getTargetY() { return 0; }
    public double getTargetZ() { return 0; }
}
