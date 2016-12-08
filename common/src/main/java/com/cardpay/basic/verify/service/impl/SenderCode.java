package com.cardpay.basic.verify.service.impl;
import com.cardpay.basic.common.constant.Constant;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.mail.MailSendClient;
import com.cardpay.basic.verify.emun.VertifyResult;
import com.cardpay.basic.redis.RedisClient;
import com.cardpay.basic.util.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * 邮箱或者手机发送验证码
 *@author rankai .
 */
@Component
public class SenderCode implements com.cardpay.basic.verify.service.SenderCode {

    @Autowired
    private LogTemplate logger;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private MailSendClient baseMail;

    /**
     * 验证邮箱或者手机号匹配，或者发送验证码，
     *
     * @param number     手机号或者邮箱地址
     * @param baseNumber 参照数据(用于对比number参数和存储的参考数据是否一致)
     * @return ResultEnum
     */
    @Override
    public ResultEnum send(String number, String... baseNumber) {
        String code = "";
        Boolean flag = Boolean.FALSE;
        //判断邮箱或者手机是否匹配
        if (baseNumber != null) {
            for (int i = 0; i < baseNumber.length; i++) {
                if (number.equals(baseNumber[i])) {
                    flag = Boolean.TRUE;
                    break;
                }
            }
        }
        //验证邮箱并发送验证码
        if (Pattern.compile(Constant.REGEX_EMAIL).matcher(number).matches()) {
            if (!flag) {
                logger.info(SenderCode.class, "验证邮箱并发送验证码",VertifyResult.EMAIL_BINDING_ERROR.getValue());
                return ResultEnum.BOUND_MAILBOX_ERROR;
            }
            Object object = redisClient.get(number);
            if (object != null) {
                code = object.toString();
            } else {
                code = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 6, null);
                redisClient.set(number, code, Constant.TIME_OUT);
            }
            baseMail.send(null, number, "验证码(乾康金融):" + code);
        } else if (Pattern.compile(Constant.REGEX_PHONE).matcher(number).matches()) {
            if (!flag) {
                logger.info(SenderCode.class, "验证邮箱并发送验证码",VertifyResult.EMAIL_BINDING_ERROR.getValue());
                return ResultEnum.BOUND_PHONE_ERROR;
            }
            Object object = redisClient.get(number);
            if (object != null) {
                code = object.toString();
            } else {
                code = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
                redisClient.set(number, code, Constant.TIME_OUT);
            }
            //预留手机发送验证码接口,目前未实现
            //basePhone.mail(null, number, "验证码(乾康金融):" + code);
        } else {
            logger.info(SenderCode.class, "验证邮箱并发送验证码",VertifyResult.NUMBER_ERROR.getValue());
            return ResultEnum.NUMBER_ERROR;
        }
        logger.info(SenderCode.class, "本次产生的验证码是:" + code + "[" + number + "]",null);
        return ResultEnum.SUCCESS;
    }
}
