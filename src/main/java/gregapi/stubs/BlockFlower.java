package gregapi.stubs;
// PHASE3: BlockFlower (MC 1.7.10) → FlowerBlock (MC 1.21).
// Stub keeps old constructor signature (int effectType) so subclasses don't need rewrite.
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public abstract class BlockFlower extends Block {
    public BlockFlower(int effectType) {
        super(BlockBehaviour.Properties.of().noCollission().instabreak().noOcclusion());
    }
}
