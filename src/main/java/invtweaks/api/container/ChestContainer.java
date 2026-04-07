package invtweaks.api.container;
// PHASE8: stub - InvTweaks API stub for @ChestContainer annotation
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ChestContainer {
    boolean isLargeChest() default false;
    int rowSize() default 9;
}
