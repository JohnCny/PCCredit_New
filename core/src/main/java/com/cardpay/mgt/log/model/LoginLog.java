package com.cardpay.mgt.log.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;


/**
 * 登陆日志实体
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Table(name = "T_LOGIN_LOG")
@ApiModel(value = "登陆日志")
public class LoginLog {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select LOGIN_LOG_SEQ.nextval from dual")
    @ApiModelProperty(value = "主键", required = true)
    private Integer id;

    /**
     * 登陆账号
     */
    @Column(name = "LOGIN_ACCOUNT")
    @ApiModelProperty(value = "登陆账号", required = true)
    private String loginAccount;

    /**
     * 操作 (0:退出1:登陆)
     */
    @Column(name = "LOGIN_OPERATION")
    @ApiModelProperty(value = "操作", required = true)
    private Integer loginOperation;

    /**
     * 登陆时间
     */
    @Column(name = "LOGIN_TIME")
    @ApiModelProperty(value = "登陆时间", required = true)
    private Date loginTime;

    /**
     * 结果()
     */
    @Column(name = "LOGIN_RESULT")
    @ApiModelProperty(value = "结果", required = true)
    private Integer loginResult;

    /**
     * 登陆IP
     */
    @Column(name = "LOGIN_IP")
    @ApiModelProperty(value = "登陆IP", required = true)
    private String loginIp;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取登陆账号
     *
     * @return LOGIN_ACCOUNT - 登陆账号
     */
    public String getLoginAccount() {
        return loginAccount;
    }

    /**
     * 设置登陆账号
     *
     * @param loginAccount 登陆账号
     */
    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    /**
     * 获取操作
     *
     * @return LOGIN_OPERATION - 操作
     */
    public Integer getLoginOperation() {
        return loginOperation;
    }

    /**
     * 设置操作
     *
     * @param loginOperation 操作
     */
    public void setLoginOperation(Integer loginOperation) {
        this.loginOperation = loginOperation;
    }

    /**
     * 获取登陆时间
     *
     * @return LOGIN_TIME - 登陆时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登陆时间
     *
     * @param loginTime 登陆时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取结果
     *
     * @return LOGIN_RESULT - 结果
     */
    public Integer getLoginResult() {
        return loginResult;
    }

    /**
     * 设置结果
     *
     * @param loginResult 结果
     */
    public void setLoginResult(Integer loginResult) {
        this.loginResult = loginResult;
    }

    /**
     * 获取登陆IP
     *
     * @return LOGIN_IP - 登陆IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置登陆IP
     *
     * @param loginIp 登陆IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }


    public static final class LoginLogBuilder {
        private Integer id;
        private String loginAccount;
        private Integer loginOperation;
        private Date loginTime;
        private Integer loginResult;
        private String loginIp;

        private LoginLogBuilder() {
        }

        public static LoginLogBuilder get() {
            return new LoginLogBuilder();
        }

        public LoginLogBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public LoginLogBuilder withLoginAccount(String loginAccount) {
            this.loginAccount = loginAccount;
            return this;
        }

        public LoginLogBuilder withLoginOperation(Integer loginOperation) {
            this.loginOperation = loginOperation;
            return this;
        }

        public LoginLogBuilder withLoginTime(Date loginTime) {
            this.loginTime = loginTime;
            return this;
        }

        public LoginLogBuilder withLoginResult(Integer loginResult) {
            this.loginResult = loginResult;
            return this;
        }

        public LoginLogBuilder withLoginIp(String loginIp) {
            this.loginIp = loginIp;
            return this;
        }

        public LoginLog build() {
            LoginLog loginLog = new LoginLog();
            loginLog.setId(id);
            loginLog.setLoginAccount(loginAccount);
            loginLog.setLoginOperation(loginOperation);
            loginLog.setLoginTime(loginTime);
            loginLog.setLoginResult(loginResult);
            loginLog.setLoginIp(loginIp);
            return loginLog;
        }
    }
}