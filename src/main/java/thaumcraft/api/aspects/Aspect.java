package thaumcraft.api.aspects;
// PHASE8: stub for compat

public class Aspect {
    public final String tag;
    public Aspect(String tag, int color, Aspect[] components, Object image, int blend) { this.tag = tag; }
    public static java.util.Map<String,Aspect> aspects = new java.util.HashMap<>();
    public static Aspect getAspect(String tag) { return null; }
}
