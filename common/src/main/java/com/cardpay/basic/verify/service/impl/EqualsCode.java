package com.cardpay.basic.verify.service.impl;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.verify.emun.VertifyResult;
import com.cardpay.basic.redis.RedisClient;
import com.cardpay.basic.common.log.LogBase;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 验证验证码
 * @author rankai .
 */
@Component
public class EqualsCode implements com.cardpay.basic.verify.service.EqualsCode {

    private static final Logger logger = LogBase.get();

    @Autowired
    private RedisClient redisClient;

    @Override
    public ResultEnum equalsCode(String number, String code) {
        Object baseCode = redisClient.get(number);
        if (baseCode == null) {
            logger.info(VertifyResult.CODE_TIME.getValue());
            return ResultEnum.CAPTCHA_TIMEOUT;
        }
        if (baseCode.toString().equals(code)) {
            redisClient.delete(number);
            return ResultEnum.SUCCESS;
        }
        logger.info(VertifyResult.CODE_ERROR.getValue());
        return ResultEnum.CAPTCHA_ERROR;
    }
}
