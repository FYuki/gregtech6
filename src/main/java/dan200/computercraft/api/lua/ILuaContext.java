package dan200.computercraft.api.lua;
// PHASE8: stub for compat
public interface ILuaContext { Object[] pullEvent(String filter) throws dan200.computercraft.api.lua.LuaException, InterruptedException; Object[] pullEventRaw(String filter) throws dan200.computercraft.api.lua.LuaException, InterruptedException; Object[] yield(Object[] arguments) throws dan200.computercraft.api.lua.LuaException, InterruptedException; }
