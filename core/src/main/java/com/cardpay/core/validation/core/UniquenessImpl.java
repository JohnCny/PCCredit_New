package com.cardpay.core.validation.core;

import com.cardpay.core.validation.Uniqueness;
import com.cardpay.core.validation.service.UniquenessMapper;
import com.cardpay.core.validation.service.UniquenessModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author rankai
 *         createTime 2016-12-2016/12/27 16:50
 */
@Component
public class UniquenessImpl implements ConstraintValidator<Uniqueness, String> {

    @Autowired
    private UniquenessMapper uniquenessMapper;

    private String table;
    private String field;

    @Override
    public void initialize(Uniqueness constraintAnnotation) {
        this.table = constraintAnnotation.table();
        this.field = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        UniquenessModel uniquenessModel = new UniquenessModel();
        uniquenessModel.setTable(this.table);
        uniquenessModel.setField(this.field);
        uniquenessModel.setValue(value);
        return this.uniquenessMapper.selectOne(uniquenessModel) != null ? Boolean.FALSE : Boolean.TRUE;
    }
}
