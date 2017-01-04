package com.cardpay.mgt.customer.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 客户移交类
 * @author wangpeng
 */
public interface TCustomerTransferService extends BaseService<TCustomerTransfer>{
    /**
     * 获取移交接收意见状态
     * @return 移交接收意见状态列表
     */
    List<SelectModel> getTransferStatus();


    /**
     * 查询客户接受列表
     *
     * @param map    移交状态&客户经理id
     * @return 客户接受列表
     */
    List<TCustomerVo> queryTransfer(Map<String, Object> map);

    /**
     * 客户接收/拒绝
     *
     * @param customerIds 客户id
     * @param flag 标记 ("接收:1, 拒绝2")
     * @return 数据库变条数
     */
    int accept(String customerIds, Integer flag);

    /**
     * 根据科技经理ID查询移交信息
     * @param customerId 客户经理Id
     * @return 移交记录
     */
    List<TCustomerTransferVo> queryById(@Param("customerId") int customerId);
}
