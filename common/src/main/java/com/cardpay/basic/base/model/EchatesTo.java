package com.cardpay.basic.base.model;

import com.cardpay.basic.common.enums.ResultEnum;

import java.io.Serializable;
import java.util.*;

/**
 * Echarts 接口请求返回结果,定义全局code值
 * Created by chenkai on 2016/11/23.
 */
public class EchatesTo extends HashMap<String, Object> implements Serializable{

    private static Map<Integer, String> RS_MAP = new HashMap<Integer, String>(){
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
        }
    };

    // 返回结果编码
    private static final String RS_CODE = "code";
    // 返回标题信息
    private static final String RS_SUBTEXT = "subText";
    // 返回图例信息
    private static final String RS_LEGEND = "legend";
    // 返回副标题信息
    private static final String RS_TITLE = "title";
    // 返回结果信息
    private static final String RS_MSG = "msg";
    // 返回结果数据
    private static final String RS_DATA = "data";
    // 返回结果参数数据
    private static final String RS_SERIES_DATA = "seriesData";
    // x轴信息
    private static final String RS_X_DATA = "xAxis";
    // 返回高-数据
    private static final String RS_DATA_H = "seriesH";
    // 返回低-数据
    private static final String RS_DATA_L = "seriesL";
    // 高-平均值
    private static final String RS_AVERAGE_H = "averageH";
    // 低-平均值
    private static final String RS_AVERAGE_L = "averageL";
    // 高-markPoint
    private static final String RS_MARKPOINT_H = "markPointH";
    // 低-markPoint
    private static final String RS_MARKPOINT_L = "markPointL";


    //返回数据结果，可能需要data里面嵌套其他复杂json结构
    private transient Map<String, Object> dataMap = new HashMap<>();

    /**
     * 构造函数,默认返回成功信息
     */
    public EchatesTo() {
        setCode(ResultEnum.SUCCESS.getValue());
        setMsg(RS_MAP.get(ResultEnum.SUCCESS.getValue()));
    }

    /**
     * 构造函数,设置状态码
     * @param code 状态码
     */
    public EchatesTo(int code){
        setCode(code);
    }

    /**
     * 沟槽函数,设置状态码和
     * @param code 状态码
     * @param msg 描述信息
     */
    public EchatesTo(int code, String msg){
        setMsg(code, msg);
    }

    /**
     * 设置状态码,若不是已定义消息则返回自定义状态码
     * @param code 状态码
     * @return 返回自身对象this
     */
    public EchatesTo setCode(int code) {
        this.put(RS_CODE, code);
        return this;
    }

    /**
     * 设置错误消息，此时会以设置的错误消息为准
     *
     * @param msg 状态码描述
     * @return  返回自身对象this
     */
    public EchatesTo setMsg(String msg){
        this.put(RS_MSG, msg);
        return this;
    }

    /**
     *设置错误消息和错误码，此时会以设置的错误消息为准
     * @param code 状态码
     * @param msg 状态码描述
     * @return  返回自身对象this
     */
    public EchatesTo setMsg(int code, String msg){
        this.put(RS_CODE, code);
        this.put(RS_MSG, msg);
        return this;
    }

    /**
     * 获取当前的错误码
     *
     * @return  状态码
     */
    public int getCode() {
        return null == this.get(RS_CODE) ? 0 : (Integer) this.get(RS_CODE);
    }

    /**
     * 获取当前的错误消息，如果为空，则返回null
     *
     * @return  code状态描述
     */
    public String getMsg() {
        return null == this.get(RS_MSG) ? null : String.valueOf(this.get(RS_MSG));
    }

    /**
     * 返回柱状图信息
     * @param title 标题
     * @param subText 副标题
     * @param list x轴信息
     * @param objList 对象集合
     * @return 返回自身对象this
     */
    public EchatesTo setData(String title, String subText, List<String> list, List<?>objList){
        dataMap.put(RS_TITLE, title);
        dataMap.put(RS_SUBTEXT, subText);
        dataMap.put(RS_LEGEND, list);
        dataMap.put(RS_SERIES_DATA, objList);
        this.put(RS_DATA, dataMap);
        return this;
    }

    /**
     *  返回柱状图信息
     * @param title 标题
     * @param listX 图例集合
     * @param objList 对象集合
     * @return 返回自身对象this
     */
    public EchatesTo setData(String title, List<String> listX, List<?>objList){
        dataMap.put(RS_TITLE, title);
        dataMap.put(RS_X_DATA, listX);
        dataMap.put(RS_SERIES_DATA, objList);
        this.put(RS_DATA, dataMap);
        return this;
    }

    /**
     * 折线图信息
     * @param title 标题 '未来一周气温变化'
     * @param subText 副标题 '详细温度信息'
     * @param legendList 图例集合 ['最高气温','最低气温']
     * @param listX X轴集合  ['周一','周二','周三','周四','周五','周六','周日']
     * @param seriesListH 高-数据 [11, 11, 15, 13, 12, 13, 10]
     * @param markPointListH 高-markPoint {type: 'max', name: '最大值'}
     * @param markLineListH 高-平均值 {type: 'average', name: '平均值'}
     * @param seriesListL 低-数据 [1, -2, 2, 5, 3, 2, 0]
     * @param markPointListL 低-markPoint {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
     * @param markLineListL 低-平均值 {type: 'average', name: '平均值'}
     * @return 返回自身对象this
     */
    public EchatesTo setData(String title, String subText, List<String> legendList, List<String> listX,
                             List<String> seriesListH, List<?>markPointListH, List<?>markLineListH
                                , List<String> seriesListL, List<?>markPointListL, List<?>markLineListL){
        dataMap.put(RS_TITLE, title);
        dataMap.put(RS_SUBTEXT, subText);
        dataMap.put(RS_LEGEND, legendList);
        dataMap.put(RS_X_DATA, listX);
        dataMap.put(RS_DATA_H, seriesListH);
        dataMap.put(RS_MARKPOINT_H, markPointListH);
        dataMap.put(RS_AVERAGE_H, markLineListH);
        dataMap.put(RS_DATA_L, seriesListL);
        dataMap.put(RS_MARKPOINT_L, markPointListL);
        dataMap.put(RS_AVERAGE_L, markLineListL);
        this.put(RS_DATA, dataMap);
        return this;
    }

}
