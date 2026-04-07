package appeng.api;
// PHASE8: stub for compat

public class AEApi {
    private static final AEApi INSTANCE = new AEApi();
    public static AEApi instance() { return INSTANCE; }
    public Registries registries() { return new Registries(); }
    public class Registries {
        public GrinderRecipeManager grinder() { return new GrinderRecipeManager(); }
    }
    public class GrinderRecipeManager {
        public void getRecipes() {}
        public void clear() {}
        public void addRecipe(net.minecraft.world.item.ItemStack input, net.minecraft.world.item.ItemStack output, int turns) {}
        public void addRecipe(net.minecraft.world.item.ItemStack input, net.minecraft.world.item.ItemStack output, net.minecraft.world.item.ItemStack output2, float chance2, int turns) {}
        public void addRecipe(net.minecraft.world.item.ItemStack input, net.minecraft.world.item.ItemStack output, net.minecraft.world.item.ItemStack output2, float chance2, net.minecraft.world.item.ItemStack output3, float chance3, int turns) {}
    }
}
