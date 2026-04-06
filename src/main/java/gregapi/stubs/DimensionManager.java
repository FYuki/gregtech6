package gregapi.stubs;
// PHASE5: DimensionManager replaced by ServerLevel.getLevel() in 1.21
import net.minecraft.server.level.ServerLevel;
@SuppressWarnings("unused")
public class DimensionManager {
    public static ServerLevel getWorld(int dim) { return null; }
    public static int[] getStaticDimensionIDs() { return new int[]{0, -1, 1}; }
}
