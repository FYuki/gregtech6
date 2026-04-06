package gregapi.stubs;
// PHASE5: WorldInfo → ServerLevelData in 1.21
import net.minecraft.nbt.CompoundTag;
@SuppressWarnings("unused")
public class WorldInfo {
    public WorldInfo(CompoundTag tag) {}
    public WorldInfo() {}
    public long getSeed() { return 0L; }
    public String getLevelName() { return "DUMMY"; }
}
