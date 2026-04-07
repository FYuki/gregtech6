package gregapi.stubs;
// PHASE8: stub for compat

import net.minecraft.nbt.CompoundTag;
public class FMLInterModComms {
    public static boolean sendMessage(String modId, String key, CompoundTag nbt) { return false; }
    public static boolean sendMessage(String modId, String key, String value) { return false; }
    public static boolean sendRuntimeMessage(Object sender, String modId, String key, String value) { return false; }
}
