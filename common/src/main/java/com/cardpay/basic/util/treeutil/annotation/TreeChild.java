package com.cardpay.basic.util.treeutil.annotation;

import java.lang.annotation.*;

/**
 * 子节点注解
 * @author yanwe
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TreeChild {
}
