package li.cil.oc.api.machine;
// PHASE8: stub for compat
public interface Context { String[] components(); boolean isPaused(); boolean pause(double seconds); void resume(String source); boolean signal(String name, Object... args); }
