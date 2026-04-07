package net.minecraft.client.renderer;
// PHASE4: stub - OpenGlHelper → LWJGL3/Mojang render helpers in 1.21
public class OpenGlHelper {
    public static boolean arbMultitexture = true;
    public static int defaultTexUnit = 0;
    public static int lightmapTexUnit = 1;
    public static void setLightmapTextureCoords(int target, float x, float y) {}
    public static void setActiveTexture(int texture) {}
    public static boolean isFramebufferEnabled() { return false; }
}
