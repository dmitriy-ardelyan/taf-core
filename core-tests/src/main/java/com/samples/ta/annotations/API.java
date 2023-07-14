package com.samples.ta.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface API {
    String url();
    Type type();
    enum Type {
        GET,
        POST,
        PUT,
        DELETE,
        PATCH
    }
}
