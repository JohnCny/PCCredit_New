package com.cardpay.basic.verify.service.impl;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.verify.emun.VertifyResult;
import com.cardpay.basic.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 验证验证码
 * @author rankai .
 */
@Component
public class EqualsCode implements com.cardpay.basic.verify.service.EqualsCode {

    @Autowired
    private LogTemplate logger;

    @Autowired
    private RedisClient redisClient;

    @Override
    public ResultEnum equalsCode(String number, String code) {
        Object baseCode = redisClient.get(number);
        if (baseCode == null) {
            logger.info(EqualsCode.class, null, VertifyResult.CODE_TIME.getValue());
            return ResultEnum.CAPTCHA_TIMEOUT;
        }
        if (baseCode.toString().equals(code)) {
            redisClient.delete(number);
            return ResultEnum.SUCCESS;
        }
        logger.info(EqualsCode.class, null, VertifyResult.CODE_ERROR.getValue());
        return ResultEnum.CAPTCHA_ERROR;
    }
}
