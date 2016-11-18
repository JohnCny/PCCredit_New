package com.cardpay.basic.common.annotation;

import java.lang.annotation.*;

/**
 * 该注解用于服务类日志
 * Created by china.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface SystemServiceLog {
    String description()  default "";
}