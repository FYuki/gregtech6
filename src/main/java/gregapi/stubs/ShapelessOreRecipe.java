package gregapi.stubs;
import net.minecraft.world.item.ItemStack;
import java.util.Collections;
import java.util.List;
// PHASE7: ShapelessOreRecipe removed from NeoForge — use datapack recipes
@SuppressWarnings("unused")
public class ShapelessOreRecipe {
    public List<Object> getInput() { return Collections.emptyList(); }
    public ItemStack getRecipeOutput() { return ItemStack.EMPTY; }
}
