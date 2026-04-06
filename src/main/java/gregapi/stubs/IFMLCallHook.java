package gregapi.stubs;
// PHASE6: IFMLCallHook (used by ASM/Mixin plugins) — deferred to Phase 6
@SuppressWarnings("unused")
public interface IFMLCallHook {
    java.util.Map<String, Object> getData();
    void injectData(java.util.Map<String, Object> data);
    String call() throws Exception;
}
