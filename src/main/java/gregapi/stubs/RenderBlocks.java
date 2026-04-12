package gregapi.stubs;
import gregapi.stubs.IIcon;
import net.minecraft.world.level.block.Block;
// PHASE4: RenderBlocks removed in MC 1.8. Modern equivalent is BakedModel + PoseStack.
// Stub for compilation; rendering will be rewritten in Phase 4.
@SuppressWarnings({"unused","FieldMayBeFinal"})
public class RenderBlocks {
    public static RenderBlocks instance = new RenderBlocks();
    public boolean enableAO = false;
    public boolean flipTexture = false;
    public boolean field_152631_f = false;
    public boolean renderFromInside = false;
    public boolean hasOverrideBlockTexture = false;
    public double renderMinX = 0, renderMaxX = 1;
    public double renderMinY = 0, renderMaxY = 1;
    public double renderMinZ = 0, renderMaxZ = 1;
    // AO fields
    public float aoLightValueScratchXYNN, aoLightValueScratchXYNP, aoLightValueScratchXYPN, aoLightValueScratchXYPP;
    public float aoLightValueScratchXYZNNN, aoLightValueScratchXYZNNP, aoLightValueScratchXYZNPN, aoLightValueScratchXYZNPP;
    public float aoLightValueScratchXYZPNN, aoLightValueScratchXYZPNP, aoLightValueScratchXYZPPN, aoLightValueScratchXYZPPP;
    public float aoLightValueScratchXZNN, aoLightValueScratchXZNP, aoLightValueScratchXZPN, aoLightValueScratchXZPP;
    public float aoLightValueScratchYZNN, aoLightValueScratchYZNP, aoLightValueScratchYZPN, aoLightValueScratchYZPP;
    public int aoBrightnessXYNN, aoBrightnessXYNP, aoBrightnessXYPN, aoBrightnessXYPP;
    public int aoBrightnessXYZNNN, aoBrightnessXYZNNP, aoBrightnessXYZNPN, aoBrightnessXYZNPP;
    public int aoBrightnessXYZPNN, aoBrightnessXYZPNP, aoBrightnessXYZPPN, aoBrightnessXYZPPP;
    public int aoBrightnessXZNN, aoBrightnessXZNP, aoBrightnessXZPN, aoBrightnessXZPP;
    public int aoBrightnessYZNN, aoBrightnessYZNP, aoBrightnessYZPN, aoBrightnessYZPP;
    public int brightnessBottomLeft, brightnessBottomRight, brightnessTopLeft, brightnessTopRight;
    // Methods
    public boolean hasOverrideBlockTexture() { return hasOverrideBlockTexture; }
    public void renderFaceXPos(Block b, int x, int y, int z, IIcon icon) {}
    public void renderFaceXNeg(Block b, int x, int y, int z, IIcon icon) {}
    public void renderFaceYPos(Block b, int x, int y, int z, IIcon icon) {}
    public void renderFaceYNeg(Block b, int x, int y, int z, IIcon icon) {}
    public void renderFaceZPos(Block b, int x, int y, int z, IIcon icon) {}
    public void renderFaceZNeg(Block b, int x, int y, int z, IIcon icon) {}
}
