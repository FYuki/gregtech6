package gregapi.stubs;
// PHASE3: IExtendedEntityProperties removed — use AttachCapabilitiesEvent in NeoForge
@SuppressWarnings("unused")
public interface IExtendedEntityProperties {
    void init(net.minecraft.world.entity.Entity entity, net.minecraft.world.level.Level level);
    void saveNBTData(net.minecraft.nbt.CompoundTag compound);
    void loadNBTData(net.minecraft.nbt.CompoundTag compound);
}
