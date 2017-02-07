package com.cardpay.mgt.process;

import com.cardpay.mgt.process.core.ReturnData;

/**
 * 进件流程服务层接口
 *
 * @author rankai
 *         createTime 2017-02-2017/2/6 9:41
 */
public interface ProcessService {


    /**
     * 准入门槛
     *
     * @param applicationId 进件ID
     * @return ReturnData对象
     */
    ReturnData applicationApproval(Integer applicationId);

}
