package com.cardpay.core.validation.core;

import com.cardpay.core.validation.IDCard;
import com.cardpay.basic.util.IDcardUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author rankai
 *         createTime 2016-12-2016/12/27 16:50
 */
public class IDCardImpl implements ConstraintValidator<IDCard, String> {

    @Override
    public void initialize(IDCard constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return Boolean.TRUE;
        } else {
            return IDcardUtil.verify(value);
        }
    }
}