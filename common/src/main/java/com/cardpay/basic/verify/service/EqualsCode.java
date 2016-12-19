package com.cardpay.basic.verify.service;

import com.cardpay.basic.common.enums.ResultEnum;

/**
 * 邮件发送验证码
 *@author rankai .
 */
public interface EqualsCode {
    /**
     * 验证邮箱或者手机验证码
     *
     * @param number 手机号或者邮箱
     * @param code   验证码
     * @return ResultEnum
     */
    ResultEnum equalsCode(String number, String code);
}
