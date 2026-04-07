package net.minecraft.world;
// PHASE4: stub - ColorizerFoliage → FoliageColor in 1.21
public class ColorizerFoliage {
    public static int getFoliageColor(double temp, double humid) {
        return net.minecraft.world.level.FoliageColor.get(temp, humid);
    }
    public static int getFoliageColorBirch() { return 0x80A755; }
    public static int getFoliageColorPine() { return 0x619961; }
    public static int getFoliageColorBasic() { return 0x48B518; }
}
