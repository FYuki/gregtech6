package micdoodle8.mods.galacticraft.api.event.wgen;
// PHASE8: Galacticraft worldgen event stub
import net.neoforged.bus.api.Event;
public class GCCoreEventPopulate extends Event {
    public final Object world;
    public final int chunkX, chunkZ;
    public GCCoreEventPopulate(Object w, int x, int z) { world=w; chunkX=x; chunkZ=z; }

    public static class Pre extends GCCoreEventPopulate {
        public Pre(Object w, int x, int z) { super(w, x, z); }
    }
    public static class Post extends GCCoreEventPopulate {
        public Post(Object w, int x, int z) { super(w, x, z); }
    }
}
