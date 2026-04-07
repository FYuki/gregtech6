package cpw.mods.fml.common;
// PHASE2: stub for old FML/Forge API

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.TYPE)
public @interface Mod {
    String modid() default "";
    String name() default "";
    String version() default "";
    @Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD)
    @interface EventHandler {}
}
