package com.cardpay.core.validation;


import com.cardpay.core.validation.core.EqualsImpl;
import com.cardpay.core.validation.group.InsertGroup;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义校验器(验证数据必须为values数组中的元素之一)
 *
 * @author rankai
 *         createTime 2016-12-2016/12/27 16:50
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EqualsImpl.class})
public @interface Equals {

    String message() default "传入数据不符合约束条件";

    Class<?>[] groups() default InsertGroup.class;

    Class<? extends Payload>[] payload() default {};

    String[] value();

}
