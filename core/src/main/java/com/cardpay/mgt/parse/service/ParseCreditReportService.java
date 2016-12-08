package com.cardpay.mgt.parse.service;

/**
 * Created by yanwe on 2016/11/30.
 */
public interface ParseCreditReportService{

    /**
     * 解析征信报告
     *
     * @param applicationId 进件id
     */
    void parseCreditReport(Integer applicationId);
}
