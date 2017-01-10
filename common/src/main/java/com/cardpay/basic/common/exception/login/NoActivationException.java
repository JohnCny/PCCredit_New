package com.cardpay.basic.common.exception.login;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 未激活异常,shiro用户登陆验证信息时,若数据库中字段判断该用户未激活则抛出该异常
 * @author rankai .
 */
public class NoActivationException extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public NoActivationException() {
        super();
    }

    public NoActivationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoActivationException(String message) {
        super(message);
    }

    public NoActivationException(Throwable cause) {
        super(cause);
    }
}
