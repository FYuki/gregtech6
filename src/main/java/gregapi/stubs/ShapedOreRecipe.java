package gregapi.stubs;
// PHASE7: stub - ShapedOreRecipe (MinecraftForge OreDict) replaced by datapack recipes in 1.21
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.level.Level;

public abstract class ShapedOreRecipe extends CustomRecipe {
    public ShapedOreRecipe() {
        super(CraftingBookCategory.MISC);
    }
    @Override
    public boolean matches(CraftingContainer container, Level world) { return false; }
    @Override
    public ItemStack assemble(CraftingContainer container, net.minecraft.core.RegistryAccess registryAccess) { return ItemStack.EMPTY; }
    @Override
    public boolean canCraftInDimensions(int width, int height) { return true; }
    @Override
    public net.minecraft.resources.ResourceLocation getId() { return new net.minecraft.resources.ResourceLocation("gregtech", getClass().getSimpleName().toLowerCase()); }
    @Override
    public net.minecraft.world.item.crafting.RecipeSerializer<?> getSerializer() { return null; }
}
