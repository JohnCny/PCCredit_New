package com.cardpay.mgt.modeifyhistory.util;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class TestBean extends GenericEntity<Integer> {

    @ApiModelProperty(value="测试数字",required = true)
    private Integer testNum;

    @ApiModelProperty(value="测试字符",required = true)
    private String testStr;

    @ApiModelProperty(value="测试日期",required = true)
    private Date testDate;

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Integer getTestNum() {
        return testNum;
    }

    public void setTestNum(Integer testNum) {
        this.testNum = testNum;
    }

    @Override
    public Integer getPK() {
        return testNum;
    }
}