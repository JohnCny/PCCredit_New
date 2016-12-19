package com.cardpay.mgt.param.service.impl;


import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.param.dao.TBusinessParamMapper;
import com.cardpay.mgt.param.model.po.TBusinessParam;
import com.cardpay.mgt.param.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务参数服务实现类
 * @author wangpeng
 */
@Service
public class ParamServiceImpl extends BaseServiceImpl<TBusinessParam> implements ParamService {

    @Autowired
    private TBusinessParamMapper tBusinessParamMapper;

    /**
     * 根据消息名称获取消息实体
     * @param name 消息名
     * @return 消息实体
     */
    public TBusinessParam getByName(String name){
        return tBusinessParamMapper.getByName(name);
    }
}
