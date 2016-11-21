package com.cardpay.basic.common.exception.base;

/**
 * 业务异常处理代码
 * @author johnmyiqn
 */
public class BusinessBaseException extends Exception{
    /**错误码*/
    private int code;
    /**错误消息*/
    private String message;
    /**
     * 业务异常构造函数
     * @param code 错误码
     * @param message 错误消息
     */
    public BusinessBaseException(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
