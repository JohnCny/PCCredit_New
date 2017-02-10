package com.cardpay.core.validation.core;

import com.cardpay.core.validation.Regex;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author rankai
 *         createTime 2016-12-2016/12/27 16:50
 */
public class RegexImpl implements ConstraintValidator<Regex, String> {

    private String[] regex;
    private boolean takeBack;

    @Override
    public void initialize(Regex constraintAnnotation) {
        this.regex = constraintAnnotation.regex();
        this.takeBack = constraintAnnotation.takeBack();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return Boolean.TRUE;
        } else {
            Boolean flag = Boolean.TRUE;
            for (int i = 0; i < regex.length; i++) {
                if (Pattern.compile(regex[i]).matcher(value).find()) {
                    flag = Boolean.FALSE;
                    if (takeBack) {
                        continue;
                    }
                    break;
                }
            }
            return takeBack ? !flag : flag;
        }
    }
}
