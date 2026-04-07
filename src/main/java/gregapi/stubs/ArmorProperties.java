package gregapi.stubs;
import gregapi.stubs.ArmorProperties;
// PHASE stub

/** PHASE8: Old Forge ArmorProperties removed in NeoForge 1.21. */
public class ArmorProperties implements Comparable<ArmorProperties> {
    public final int priority;
    public final double ratio;
    public final int maxAbsorb;
    public ArmorProperties(int priority, double ratio, int maxAbsorb) {
        this.priority = priority; this.ratio = ratio; this.maxAbsorb = maxAbsorb;
    }
    @Override public int compareTo(ArmorProperties o) { return Integer.compare(this.priority, o.priority); }
}
