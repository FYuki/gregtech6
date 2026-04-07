package net.minecraft.world;
// PHASE3: stub - EnumSkyBlock was removed in 1.13+; brightness is per-channel in 1.21
public enum EnumSkyBlock {
    Sky(15),
    Block(15);
    public final int defaultLightValue;
    EnumSkyBlock(int d) { this.defaultLightValue = d; }
}
