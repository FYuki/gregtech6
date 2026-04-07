package gregapi.block;
// PHASE3: stub — replaced in 1.21

import net.minecraft.world.level.material.MapColor;
/** PHASE3: net.minecraft.world.level.material.Material was removed in 1.21.
 *  This stub allows existing subclasses to compile. Rewrite in Phase 3. */
public class Material {
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
