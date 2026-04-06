package gregapi.stubs;

// PHASE4: IIcon removed. Modern equivalent is TextureAtlasSprite.
// Stub for compilation; icon/texture system will be rewritten in Phase 4.
@SuppressWarnings("unused")
public interface IIcon {
	float getMinU();
	float getMaxU();
	float getMinV();
	float getMaxV();
	String getIconName();
	float getInterpolatedU(double u);
	float getInterpolatedV(double v);
}
