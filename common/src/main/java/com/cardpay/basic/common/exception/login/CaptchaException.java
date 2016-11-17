package com.cardpay.basic.common.exception.login;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 验证码异常类,shiro用户登陆验证信息时若用户输入验证码错误则抛出该异常
 * @author rankai .
 */
public class CaptchaException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public CaptchaException() {
        super();
    }

    public CaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaptchaException(String message) {
        super(message);
    }

    public CaptchaException(Throwable cause) {
        super(cause);
    }
}
