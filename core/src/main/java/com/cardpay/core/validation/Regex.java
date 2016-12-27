package com.cardpay.core.validation;

import com.cardpay.core.validation.core.RegexImpl;
import com.cardpay.core.validation.group.InsertGroup;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 验证数据包含与传入正则表达式(非法匹配)匹配的字符
 *
 * @author rankai
 *         createTime 2016-12-2016/12/27 16:50
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {RegexImpl.class})
public @interface Regex {

    String[] regex();

    /**
     * 表示对于所写的正则,是采用还是排除
     *
     * @return true:符合全部正则则通过，false符合一个正则则不通过
     */
    boolean takeBack() default true;

    String message() default "传入参数包含约束外字符";

    Class<?>[] groups() default InsertGroup.class;

    Class<? extends Payload>[] payload() default {};
}
