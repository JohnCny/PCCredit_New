package com.cardpay.mgt.menu.exception;

/**
 * 强制退出递归
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/18 13:43
 */
public class EndRecursionException extends Exception {

    public EndRecursionException(String message) {
        super(message);
    }
}
