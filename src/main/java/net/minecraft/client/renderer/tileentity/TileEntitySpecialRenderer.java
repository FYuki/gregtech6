package net.minecraft.client.renderer.tileentity;
// PHASE4: stub - TileEntitySpecialRenderer → BlockEntityRenderer in 1.21
import net.minecraft.world.level.block.entity.BlockEntity;
public abstract class TileEntitySpecialRenderer<T extends BlockEntity> {
    protected TileEntityRendererDispatcher rendererDispatcher;
    public abstract void renderTileEntityAt(T te, double x, double y, double z, float partialTicks, int destroyStage);
}
