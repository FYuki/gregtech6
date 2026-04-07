package gregapi.block;
// PHASE3: stub — replaced in 1.21

import net.minecraft.world.level.material.MapColor;
/** PHASE3: net.minecraft.world.level.material.Material was removed in 1.21.
 *  This stub allows existing subclasses to compile. Rewrite in Phase 3. */
public class Material {
    // PHASE3: static Material constants mirroring old net.minecraft.block.material.Material
    public static final Material air           = new Material(MapColor.NONE);
    public static final Material lava          = new Material(MapColor.COLOR_RED);
    public static final Material water         = new Material(MapColor.WATER);
    public static final Material rock          = new Material(MapColor.STONE);
    public static final Material iron          = new Material(MapColor.METAL);
    public static final Material wood          = new Material(MapColor.WOOD);
    public static final Material grass         = new Material(MapColor.GRASS);
    public static final Material ground        = new Material(MapColor.DIRT);
    public static final Material fire          = new Material(MapColor.NONE);
    public static final Material cactus        = new Material(MapColor.COLOR_GREEN);
    public static final Material cloth         = new Material(MapColor.WOOL);
    public static final Material sand          = new Material(MapColor.SAND);
    public static final Material snow          = new Material(MapColor.SNOW);
    public static final Material ice           = new Material(MapColor.ICE);
    public static final Material packedIce     = new Material(MapColor.ICE);
    public static final Material craftedSnow   = new Material(MapColor.SNOW);
    public static final Material circuits      = new Material(MapColor.METAL);
    public static final Material anvil         = new Material(MapColor.METAL);
    public static final Material leaves        = new Material(MapColor.PLANT);
    public static final Material plants        = new Material(MapColor.PLANT);
    public static final Material gourd         = new Material(MapColor.COLOR_GREEN);
    public static final Material glass         = new Material(MapColor.NONE);
    public static final Material tnt           = new Material(MapColor.COLOR_RED);
    public static final Material coral         = new Material(MapColor.COLOR_PINK);
    public static final Material vine          = new Material(MapColor.PLANT);
    public static final Material portal        = new Material(MapColor.NONE);
    public static final Material carpet        = new Material(MapColor.WOOL);
    public static final Material dragonEgg     = new Material(MapColor.NONE);
    public static final Material piston        = new Material(MapColor.STONE);
    public static final Material barrier       = new Material(MapColor.NONE);
    public static final Material sponge        = new Material(MapColor.COLOR_YELLOW);
    public static final Material clay          = new Material(MapColor.CLAY);
    public static final Material web           = new Material(MapColor.WOOL);
    public static final Material cake          = new Material(MapColor.NONE);
    public static final Material redstoneLight = new Material(MapColor.NONE);

    public final MapColor color;
    public Material(MapColor color) { this.color = color; }
    public Material setBurning() { return this; }
    public Material setReplaceable() { return this; }
    public Material setNoPushMobility() { return this; }
    public Material setImmovableMobility() { return this; }
    public Material setAdventureModeExempt() { return this; }
    public Material setRequiresTool() { return this; }
    public boolean isOpaque() { return true; }
    public boolean isLiquid() { return false; }
    public boolean isSolid() { return true; }
    public boolean blocksMovement() { return true; }
    public boolean isFlammable() { return false; }
    public boolean isReplaceable() { return false; }
    public net.minecraft.world.level.material.PushReaction getPushReaction() {
        return net.minecraft.world.level.material.PushReaction.NORMAL;
    }
}
