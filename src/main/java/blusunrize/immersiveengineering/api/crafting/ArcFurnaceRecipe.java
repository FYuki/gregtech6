package blusunrize.immersiveengineering.api.crafting;
// PHASE8: stub for compat
import net.minecraft.world.item.ItemStack; public class ArcFurnaceRecipe { public static java.util.List<ArcFurnaceRecipe> recipeList = new java.util.ArrayList<>(); public ItemStack output; public ItemStack input; public ItemStack[] additives; public ArcFurnaceRecipe(String key, ItemStack output, ItemStack slag, int time, int energy, ItemStack input, ItemStack... additives) { this.output=output; this.input=input; this.additives=additives; } }
