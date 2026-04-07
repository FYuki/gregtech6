package dan200.computercraft.api.peripheral;
// PHASE8: stub for compat
public interface IComputerAccess { String getAttachmentName(); void queueEvent(String event, Object[] arguments); Object[] executeMainThreadTask(dan200.computercraft.api.peripheral.IComputerAccess computer) throws Exception; }
