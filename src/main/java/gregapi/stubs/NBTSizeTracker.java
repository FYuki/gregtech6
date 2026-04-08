package gregapi.stubs;
/** PHASE3: stub — net.minecraft.nbt.NBTSizeTracker was removed in 1.18+; NbtSizeTracker/NbtAccounter replaced it */
public class NBTSizeTracker {
    public static final NBTSizeTracker INFINITE = new NBTSizeTracker(0L);
    private final long max;
    public NBTSizeTracker(long max) { this.max = max; }
    public void read(long bytes) {}
}
