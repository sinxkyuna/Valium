package dev.sinxkyuna.valium.event.bus.annotations;

import dev.sinxkyuna.valium.event.bus.Priorities;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EventLink { byte value() default Priorities.MEDIUM; }