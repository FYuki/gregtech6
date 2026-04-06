package gregapi.stubs;
// PHASE3/7: GameData removed — use BuiltInRegistries in 1.21
@SuppressWarnings("unused")
public class GameData {
    public static net.minecraft.resources.ResourceLocation getBlockRegistryName(net.minecraft.world.level.block.Block block) {
        return net.minecraft.core.registries.BuiltInRegistries.BLOCK.getKey(block);
    }
    public static net.minecraft.resources.ResourceLocation getItemRegistryName(net.minecraft.world.item.Item item) {
        return net.minecraft.core.registries.BuiltInRegistries.ITEM.getKey(item);
    }
}
