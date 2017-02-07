package com.cardpay.mgt.application.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * IPC增删改查
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/6 10:04
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IpcCRUD {
}
