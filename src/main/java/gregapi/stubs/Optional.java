package gregapi.stubs;
// PHASE3: cpw.mods.fml.common.Optional replaced by @Nullable in NeoForge 1.21
import java.lang.annotation.*;
@SuppressWarnings("unused")
public @interface Optional {
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
    @interface Interface { String iface() default ""; String modid() default ""; }
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
    @interface Method { String modid() default ""; }
}
