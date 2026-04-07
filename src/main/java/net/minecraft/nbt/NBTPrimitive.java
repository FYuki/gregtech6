package net.minecraft.nbt;
// PHASE8: stub - NBTPrimitive was removed in 1.21 (renamed to NumericTag).
// Used via Tag.NBTPrimitive in old code; resolved here as standalone type.
public interface NBTPrimitive {
    long getAsLong();
    int getAsInt();
    short getAsShort();
    byte getAsByte();
    double getAsDouble();
    float getAsFloat();
    /** PHASE8: stub - func_150291_c was the 1.7.10 obfuscated getLong() */
    default long func_150291_c() { return getAsLong(); }
}
