package gregapi.stubs;
/** PHASE8: stub — Forestry IIndividual API */
public interface IIndividual {
    boolean isAnalyzed();
    boolean isPureBred();
    String getDisplayName();
    boolean analyze();
    void writeToNBT(net.minecraft.nbt.CompoundTag tag);
}
