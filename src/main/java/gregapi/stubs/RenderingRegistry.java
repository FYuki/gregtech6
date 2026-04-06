package gregapi.stubs;
// PHASE4: RenderingRegistry removed — use ModelEvent in NeoForge 1.21
@SuppressWarnings("unused")
public class RenderingRegistry {
    public static int getNextAvailableRenderId() { return 0; }
    public static void registerBlockHandler(ISimpleBlockRenderingHandler handler) {}
    public static void registerEntityRenderingHandler(Class<?> entityClass, Object renderer) {}
}
