package gregapi.stubs;

// PHASE3: FluidRegistry removed from NeoForge 1.21 — use DeferredRegister<Fluid> + BuiltInRegistries.FLUID
// This stub keeps FL.java, FluidGT, and all fluid utils compiling during Phase 2.
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class FluidRegistry {
    /** Vanilla water fluid — same as Fluids.WATER. */
    public static final Fluid WATER = Fluids.WATER;
    /** Vanilla lava fluid — same as Fluids.LAVA. */
    public static final Fluid LAVA  = Fluids.LAVA;

    private static final Map<String, Fluid> NAME_TO_FLUID = new HashMap<>();
    private static final Map<Fluid, String> FLUID_TO_NAME = new HashMap<>();

    static {
        NAME_TO_FLUID.put("water", Fluids.WATER);
        NAME_TO_FLUID.put("lava",  Fluids.LAVA);
        FLUID_TO_NAME.put(Fluids.WATER, "water");
        FLUID_TO_NAME.put(Fluids.LAVA,  "lava");
    }

    /**
     * Register a GT6 fluid so it can be found by name.
     * PHASE3: Replace with DeferredRegister<Fluid> + FluidType registration.
     */
    public static boolean registerFluid(Fluid fluid) {
        if (fluid == null) return false;
        String name = fluidName(fluid);
        if (NAME_TO_FLUID.containsKey(name)) return false;
        NAME_TO_FLUID.put(name, fluid);
        FLUID_TO_NAME.put(fluid, name);
        return true;
    }

    /** Look up a fluid by its name (GT6 internal name or registry path). */
    public static Fluid getFluid(String name) {
        if (name == null || name.isEmpty()) return null;
        return NAME_TO_FLUID.get(name);
    }

    /** PHASE3: No integer fluid IDs in NF 1.21 — always returns null. */
    public static Fluid getFluid(int id) { return null; }

    /** PHASE3: No integer fluid IDs in NF 1.21 — returns index from name map or -1. */
    public static int getFluidID(Fluid fluid) {
        if (fluid == null) return -1;
        String name = fluidName(fluid);
        int i = 0;
        for (String k : NAME_TO_FLUID.keySet()) { if (k.equals(name)) return i; i++; }
        return -1;
    }

    /** PHASE3: No integer fluid IDs in NF 1.21. */
    public static int getFluidID(String name) {
        if (name == null) return -1;
        int i = 0;
        for (String k : NAME_TO_FLUID.keySet()) { if (k.equals(name)) return i; i++; }
        return -1;
    }

    public static boolean isFluidRegistered(Fluid fluid) {
        return fluid != null && FLUID_TO_NAME.containsKey(fluid);
    }

    public static boolean isFluidRegistered(String name) {
        return name != null && NAME_TO_FLUID.containsKey(name);
    }

    /** PHASE3: No integer fluid IDs in NF 1.21 — returns max index in name map. */
    public static int getMaxID() { return NAME_TO_FLUID.size() - 1; }

    /** Get the GT6/registry name for a fluid. */
    private static String fluidName(Fluid f) {
        if (f == null) return "";
        if (FLUID_TO_NAME.containsKey(f)) return FLUID_TO_NAME.get(f);
        // Fall back to vanilla registry
        net.minecraft.resources.ResourceLocation key = net.minecraft.core.registries.BuiltInRegistries.FLUID.getKey(f);
        return key == null ? "" : key.getPath();
    }
}
