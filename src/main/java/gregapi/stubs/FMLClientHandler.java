package gregapi.stubs;
// PHASE4: FMLClientHandler removed — use Minecraft.getInstance() in 1.21
@SuppressWarnings("unused")
public class FMLClientHandler {
    public static FMLClientHandler instance() { return new FMLClientHandler(); }
    public net.minecraft.client.Minecraft getClient() { return net.minecraft.client.Minecraft.getInstance(); }
}
