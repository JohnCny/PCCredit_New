package com.cardpay.mgt.application.exception;

/**
 * 未找到进件模版异常
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/6 9:34
 */
public class NoSuchApplicationTemplateError extends Exception {

    public NoSuchApplicationTemplateError(String message) {
        super(message);
    }
}
