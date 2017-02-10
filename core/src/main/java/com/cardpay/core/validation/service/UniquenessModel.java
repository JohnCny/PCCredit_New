package com.cardpay.core.validation.service;

import com.cardpay.basic.base.model.GenericEntity;

/**
 * 验证字段重复的Model
 *
 * @author rankai
 *         createTime 2016-12-2016/12/27 16:48
 */
public class UniquenessModel extends GenericEntity<Integer> {

    private String table;
    private String field;
    private String value;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}
