package com.zhxh.core.data.meta.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataTable {
    String value() default "";
}
