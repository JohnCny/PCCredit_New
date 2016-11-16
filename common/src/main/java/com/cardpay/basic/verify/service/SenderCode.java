package com.cardpay.basic.verify.service;

import com.cardpay.basic.common.enums.ResultEnum;

/**
 * 验证码接口
 *@author rankai .
 */
public interface SenderCode {
    /**
     * 给发送邮箱或者手机
     *
     * @param number     手机号或者邮箱地址
     * @param baseNumber 参照数据(用于对比number参数和存储的参考数据是否一致)
     * @return ResultEnum
     */
    ResultEnum send(String number, String... baseNumber);
}
