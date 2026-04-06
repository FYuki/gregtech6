package gregapi.stubs;
// PHASE6: IFMLLoadingPlugin (ASM transformer plugin) — deferred to Phase 6 (Mixin)
import java.lang.annotation.*;
@SuppressWarnings("unused")
public interface IFMLLoadingPlugin {
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
    @interface Name { String value(); }
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
    @interface MCVersion { String value(); }
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
    @interface TransformerExclusions { String[] value() default {}; }
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
    @interface SortingIndex { int value() default 0; }
    String[] getASMTransformerClass();
    String getModContainerClass();
    String getSetupClass();
    void injectData(java.util.Map<String, Object> data);
    String getAccessTransformerClass();
}
