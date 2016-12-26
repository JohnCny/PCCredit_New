package com.cardpay.basic.common.annotation;


import java.lang.annotation.*;

/**
 * 该注解用于controller日志
 *
 * @author licho
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemControllerLog {
    String description() default "";


}