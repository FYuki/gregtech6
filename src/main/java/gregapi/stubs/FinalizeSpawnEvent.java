package gregapi.stubs;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.Event;

/** PHASE3: stub — replaces MobSpawnEvent.CheckSpawn and MobSpawnEvent.FinalizeSpawn.
 *  In NeoForge 1.21.4, FinalizeSpawn became a top-level class; stubs both for compilation. */
public class FinalizeSpawnEvent extends Event {
    public Mob entityLiving;
    public Level world;
    public double x, y, z;

    public FinalizeSpawnEvent(Mob entity, Level world, double x, double y, double z) {
        this.entityLiving = entity;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public FinalizeSpawnEvent() {}
}
