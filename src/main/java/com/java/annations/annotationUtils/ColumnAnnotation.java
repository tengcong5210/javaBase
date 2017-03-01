package com.java.annations.annotationUtils;

import java.lang.annotation.*;

/**
 * Created by ibm on 2017/3/1.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColumnAnnotation {
    public String desc() default "";
}
