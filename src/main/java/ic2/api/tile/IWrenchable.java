package ic2.api.tile;
// PHASE8: stub for compat
public interface IWrenchable { int getFacing(); boolean setFacing(short facing); boolean wrenchCanSetFacing(Object player, int side); boolean wrenchCanRemove(Object player); float getWrenchDropRate(); Object getWrenchDrop(Object player); }
