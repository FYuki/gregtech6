package cpw.mods.fml.common;
// PHASE2: stub for old FML/Forge API

import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.FIELD)
public @interface SidedProxy {
    String modId() default "";
    String clientSide();
    String serverSide();
}
