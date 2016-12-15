package com.cardpay.core.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自定义Token,用于封装用户登陆信息
 *
 * @author rankai
 */
public class CaptchaAuthenticationToken extends UsernamePasswordToken {
    private static final long serialVersionUID = -4456821563052424968L;

    /**
     * 验证码
     */
    private String captcha;
    /**
     * 验证码id
     */
    private String kaptchaUid;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getKaptchaUid() {
        return kaptchaUid;
    }

    public void setKaptchaUid(String request) {
        this.kaptchaUid = request;
    }

    /**
     * @param username    用户名
     * @param password    用户密码
     * @param captcha     验证码
     * @param kaptchaUUID 验证码产生时保存验证码存储在缓存中的uuid
     */
    public CaptchaAuthenticationToken(String username, String password, String captcha, String kaptchaUUID) {
        super(username, password);
        this.captcha = captcha;
        this.kaptchaUid = kaptchaUUID;
    }
}
