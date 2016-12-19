package com.cardpay.basic.base.model;

import com.cardpay.basic.common.enums.ResultEnum;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * api接口请求返回结果,定义全局返回code值
 *
 * @author johnmyqin
 */
public class ResultTo extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = -6125210369527938613L;

    /**
     * 返回结果MAP集合，key为错误编码，value为编码对应的错误描述
     */
    private static Map<Integer, String> RS_MAP = new HashMap<Integer, String>() {
        {
            put(ResultEnum.SUCCESS.getValue(), "success");
            put(ResultEnum.SERVICE_ERROR.getValue(), "server error");
            put(ResultEnum.NO_AUTHORITY.getValue(), "no authority");
            put(ResultEnum.NOT_FOUND.getValue(), "not found");
            put(ResultEnum.PARAM_ERROR.getValue(), "param error");
            put(ResultEnum.TOKEN_ERROR.getValue(), "token error");
            put(ResultEnum.USER_PWD_ERROR.getValue(), "user password error");
            put(ResultEnum.USER_EXIST.getValue(), "user exist");
            put(ResultEnum.NO_ACTIVATION_EXCEPTION.getValue(), "no activation exception");
            put(ResultEnum.UNKNOWN_ACCOUNT.getValue(), "unknown account");
            put(ResultEnum.LOCKED_ACCOUNT.getValue(), "locked account");
            put(ResultEnum.CAPTCHA_ERROR.getValue(), "captcha error");
            put(ResultEnum.TOO_MANY_ERRORS.getValue(), "too many errors");
            put(ResultEnum.CAPTCHA_TIMEOUT.getValue(), "captcha timeout");
            put(ResultEnum.CAPTCHA_NULL.getValue(), "captcha null");
            put(ResultEnum.NO_LOGIN.getValue(), "no login");
            put(ResultEnum.NO_PERMITTION.getValue(), "no permittion");
            put(ResultEnum.BOUND_MAILBOX_ERROR.getValue(), "bound mailbox error");
            put(ResultEnum.BOUND_PHONE_ERROR.getValue(), "bound phone error");
            put(ResultEnum.NUMBER_ERROR.getValue(), "illegal mail or phone number");
            put(ResultEnum.OLD_PASSWORD_ERROR.getValue(), "old password error");
            put(ResultEnum.DISABLED_ACCOUNT.getValue(), "account disabled");
            put(ResultEnum.ACCOUNT_OR_PASSWORD_NULL.getValue(), "account or password is null");
            put(ResultEnum.REQUIRED_PARAMETER_EMPTY.getValue(), "the required parameters cannot be empty");
            put(ResultEnum.OPERATION_FAILED.getValue(), "operation failed");
            put(ResultEnum.API_TIMEOUT.getValue(), "api timeout");

        }
    };

    // 返回结果编码
    private static final String RS_CODE = "code";
    // 返回结果信息
    private static final String RS_MSG = "msg";
    // 返回结果数据
    private static final String RS_DATA = "data";
    //返回数据结果，可能需要data里面嵌套其他复杂json结构
    private transient Map<String, Object> dataMap = new HashMap<>();

    /**
     * 构造函数，默认设置为成功状态码和描述
     */
    public ResultTo() {
        setCode(ResultEnum.SUCCESS.getValue());
        setMsg(RS_MAP.get(ResultEnum.SUCCESS.getValue()));
    }

    /**
     * 构造函数，设置错误码，会主动从错误码映射表中查询对应的描述
     *
     * @param code 状态码
     */
    public ResultTo(int code) {
        setCode(code);
    }

    /**
     * 构造函数，设置错误码，会主动从错误码映射表中查询对应的描述
     *
     * @param resultEnum 状态码
     */
    public ResultTo(ResultEnum resultEnum) {
        setCode(resultEnum.getValue());
    }

    /**
     * 构造函数，设置错误消息和错误码，此时会以设置的错误消息为准
     *
     * @param code 状态码
     * @param msg  状态码描述信息
     */
    public ResultTo(int code, String msg) {
        setMsg(code, msg);
    }

    /**
     * 设置错误码，会主动从错误码映射表中查询对应的描述
     *
     * @param code 状态码
     * @return 返回自身对象this
     */
    public ResultTo setCode(int code) {
        this.put(RS_CODE, code);
        if (null != RS_MAP.get(code)) {
            this.put(RS_MSG, RS_MAP.get(code));
        }
        return this;
    }

    /**
     * 设置错误消息和错误码，此时会以设置的错误消息为准
     *
     * @param code 状态码
     * @param msg  状态码描述
     * @return 返回自身对象this
     */
    public ResultTo setMsg(int code, String msg) {
        this.put(RS_CODE, code);
        this.put(RS_MSG, msg);
        return this;
    }

    /**
     * 设置错误消息，此时会以设置的错误消息为准
     *
     * @param msg 状态码描述
     * @return 返回自身对象this
     */
    public ResultTo setMsg(String msg) {
        this.put(RS_MSG, msg);
        return this;
    }

    /**
     * 设置内容，默认key为content，返回json：{"data":{}}或{"data":[]}
     *
     * @param data 数据
     * @return 返回自身对象this
     */
    public ResultTo setData(Object data) {
        setData(RS_DATA, data);
        return this;
    }

    /**
     * 设置KEY和内容，如需要返回:{"user":{}}或{"user":[]}；则设置key=user
     *
     * @param key 键
     * @param obj 数据对象
     * @return 返回自身对象this
     */
    public ResultTo setData(String key, Object obj) {
        this.put(key, obj);
        return this;
    }

    /**
     * 获取当前的错误码
     *
     * @return 状态码
     */
    public int getCode() {
        return null == this.get(RS_CODE) ? 0 : (Integer) this.get(RS_CODE);
    }

    /**
     * 获取当前的错误消息，如果为空，则返回null
     *
     * @return code状态描述
     */
    public String getMsg() {
        return null == this.get(RS_MSG) ? null : String.valueOf(this.get(RS_MSG));
    }


    /**
     * 设置data的KEY和内容，如需要返回:{"data":{"user":[]}}则设置key=user
     *
     * @param key 键
     * @param obj 数据对象
     * @return 返回自身对象this
     */
    public ResultTo setDataMap(String key, Object obj) {
        dataMap.put(key, obj);
        this.put(RS_DATA, dataMap);
        return this;
    }
}