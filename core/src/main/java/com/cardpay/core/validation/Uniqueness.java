package com.cardpay.core.validation;

import com.cardpay.core.validation.core.UniquenessImpl;
import com.cardpay.core.validation.group.InsertGroup;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 验证字段值是否存在
 *
 * @author rankai
 *         createTime 2016-12-2016/12/27 16:50
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {UniquenessImpl.class})
public @interface Uniqueness {

    String table();

    String field();

    String message();

    Class<?>[] groups() default InsertGroup.class;

    Class<? extends Payload>[] payload() default {};

}
