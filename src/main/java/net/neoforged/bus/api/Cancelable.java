package net.neoforged.bus.api;
// PHASE8: stub - @Cancelable annotation for NeoForge events
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Cancelable {}
