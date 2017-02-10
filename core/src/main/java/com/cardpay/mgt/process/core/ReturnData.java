package com.cardpay.mgt.process.core;

/**
 * 流程返回结果
 *
 * @author rankai
 *         createTime 2017-02-2017/2/6 13:59
 */
public class ReturnData {


    private boolean isPass;

    private String message;


    public ReturnData() {
        this.isPass = Boolean.FALSE;
    }

    public ReturnData(boolean flag) {
        this.isPass = flag;
    }

    public boolean isPass() {
        return isPass;
    }

    public String getMessage() {
        return message;
    }

    public ReturnData setMessage(String message) {
        this.message = message;
        return this;
    }
}
