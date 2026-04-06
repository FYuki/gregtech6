package gregapi.stubs;
// PHASE4: ISimpleBlockRenderingHandler removed — use BakedModel in 1.21
@SuppressWarnings("unused")
public interface ISimpleBlockRenderingHandler {
    void renderInventoryBlock(net.minecraft.world.level.block.Block block, int metadata, int modelID, Object renderer);
    boolean renderWorldBlock(Object world, int x, int y, int z, net.minecraft.world.level.block.Block block, int modelID, Object renderer);
    boolean shouldRender3DInInventory(int modelID);
    int getRenderId();
}
