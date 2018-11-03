package com.zhxh.core.data.meta;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataTable {
    String tableName() default "";
}
