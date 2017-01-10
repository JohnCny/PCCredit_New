package com.cardpay.core.validation.core;

import com.cardpay.core.validation.Equals;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author rankai
 *         createTime 2016-12-2016/12/27 16:50
 */
public class EqualsImpl implements ConstraintValidator<Equals, String> {

    private String[] values;

    @Override
    public void initialize(Equals constraintAnnotation) {
        this.values = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return true;
        } else {
            Boolean flag = Boolean.FALSE;
            for (int i = 0; i < values.length; i++) {
                if (value.equals(values[i])) {
                    flag = Boolean.TRUE;
                    break;
                }
            }
            return flag;
        }
    }
}
