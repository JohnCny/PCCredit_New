package com.cardpay.mgt.log.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_OPERATION_LOG")
@ApiModel(value="操作日志")
public class TOperationLog {
    /**
     * 操作日志id
     */
    @Id
    @Column(name = "OPERATION_LOG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select OPERATION_LOG_SEQ.nextval from dual")
    @ApiModelProperty(value="操作日志id",required = true)
    private Integer operationLogId;

    /**
     * 操作人
     */
    @Column(name = "OPERATION_USER")
    @ApiModelProperty(value="操作人",required = true)
    private String operationUser;

    /**
     * 模块名称
     */
    @Column(name = "OPERATION_MODULE")
    @ApiModelProperty(value="模块名称",required = true)
    private String operationModule;

    /**
     * 操作类型
     */
    @Column(name = "OPERATION_TYPE")
    @ApiModelProperty(value="操作类型",required = true)
    private String operationType;

    /**
     * 操作时间
     */
    @Column(name = "OPERATION_TIME")
    @ApiModelProperty(value="操作时间",required = true)
    private Date operationTime;

    /**
     * 操作ip
     */
    @Column(name = "OPERATION_IP")
    @ApiModelProperty(value="操作ip",required = true)
    private String operationIp;

    /**
     * 操作结果
     */
    @Column(name = "OPERATION_RESULT")
    @ApiModelProperty(value="操作结果",required = true)
    private String operationResult;

    /**
     * 获取操作日志id
     *
     * @return OPERATION_LOG_ID - 操作日志id
     */
    public Integer getOperationLogId() {
        return operationLogId;
    }

    /**
     * 设置操作日志id
     *
     * @param operationLogId 操作日志id
     */
    public void setOperationLogId(Integer operationLogId) {
        this.operationLogId = operationLogId;
    }

    /**
     * 获取操作人
     *
     * @return OPERATION_USER - 操作人
     */
    public String getOperationUser() {
        return operationUser;
    }

    /**
     * 设置操作人
     *
     * @param operationUser 操作人
     */
    public void setOperationUser(String operationUser) {
        this.operationUser = operationUser;
    }

    /**
     * 获取模块名称
     *
     * @return OPERATION_MODULE - 模块名称
     */
    public String getOperationModule() {
        return operationModule;
    }

    /**
     * 设置模块名称
     *
     * @param operationModule 模块名称
     */
    public void setOperationModule(String operationModule) {
        this.operationModule = operationModule;
    }

    /**
     * 获取操作类型
     *
     * @return OPERATION_TYPE - 操作类型
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * 设置操作类型
     *
     * @param operationType 操作类型
     */
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    /**
     * 获取操作时间
     *
     * @return OPERATION_TIME - 操作时间
     */
    public Date getOperationTime() {
        return operationTime;
    }

    /**
     * 设置操作时间
     *
     * @param operationTime 操作时间
     */
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    /**
     * 获取操作ip
     *
     * @return OPERATION_IP - 操作ip
     */
    public String getOperationIp() {
        return operationIp;
    }

    /**
     * 设置操作ip
     *
     * @param operationIp 操作ip
     */
    public void setOperationIp(String operationIp) {
        this.operationIp = operationIp;
    }

    /**
     * 获取操作结果
     *
     * @return OPERATION_RESULT - 操作结果
     */
    public String getOperationResult() {
        return operationResult;
    }

    /**
     * 设置操作结果
     *
     * @param operationResult 操作结果
     */
    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }
}