package dan200.computercraft.api.peripheral;
// PHASE8: stub for compat
public interface IPeripheral { String getType(); String[] getMethodNames(); Object[] callMethod(dan200.computercraft.api.peripheral.IComputerAccess computer, dan200.computercraft.api.lua.ILuaContext context, int method, Object[] arguments) throws dan200.computercraft.api.lua.LuaException, InterruptedException; boolean equals(IPeripheral other); void attach(IComputerAccess computer); void detach(IComputerAccess computer); }
