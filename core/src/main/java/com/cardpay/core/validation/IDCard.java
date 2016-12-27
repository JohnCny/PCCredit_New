package com.cardpay.core.validation;

import com.cardpay.core.validation.core.IDCardImpl;
import com.cardpay.core.validation.group.InsertGroup;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义身份证格式验证
 *
 * @author rankai
 *         createTime 2016-12-2016/12/27 16:50
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IDCardImpl.class})
public @interface IDCard {
    String message() default "身份证号码不正确";

    Class<?>[] groups() default InsertGroup.class;

    Class<? extends Payload>[] payload() default {};
}
