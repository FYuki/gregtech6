package net.minecraft.nbt;
// PHASE8: stub - NBTTagString was renamed to StringTag in 1.21
// StringTag constructor is package-private in 1.21; wrap via factory.
public class NBTTagString implements net.minecraft.nbt.Tag {
    private final StringTag delegate;
    public NBTTagString(String value) {
        this.delegate = StringTag.valueOf(value);
    }
    /** Delegate to the actual StringTag for list operations. */
    public StringTag getDelegate() { return delegate; }
    /** PHASE8: stub - func_150285_a_ was the obfuscated getString() in 1.7.10 */
    public String func_150285_a_() { return delegate.getAsString(); }
    public String getAsString() { return delegate.getAsString(); }
}
