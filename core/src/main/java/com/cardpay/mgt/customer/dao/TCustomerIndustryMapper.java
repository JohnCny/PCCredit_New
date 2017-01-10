package com.cardpay.mgt.customer.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.customer.model.TCustomerIndustry;
import com.cardpay.mgt.customer.model.vo.TCustomerIndustryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 客户所属行业Mapper
 * @author yanweichen
 */
public interface TCustomerIndustryMapper extends BasicMapper<TCustomerIndustry> {

    /**
     * 批量添加行业信息
     * @param list 行业id,客户id
     * @return 数据库变记录
     */
    int batchInsert(List<TCustomerIndustry> list);

    /**
     * 查询客户所属行业信息
     * @param customerId 客户id
     * @return 客户所属行业信息
     */
    List<TCustomerIndustryVo> queryById(@Param("customerId") int customerId);

    /**
     * 批量更新
     * @param list 参数
     * @return 数据库变记录
     */
    int batchUpdate(List<TCustomerIndustry> list);
}