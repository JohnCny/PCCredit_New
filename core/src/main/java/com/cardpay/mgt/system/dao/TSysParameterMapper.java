package com.cardpay.mgt.system.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.system.model.TSysParameter;
import com.cardpay.mgt.system.model.vo.TSysParameterVo;

import java.util.List;
import java.util.Map;

/**
 * 系统参数配置Mapper
 * @auther chenkai
 */
public interface TSysParameterMapper extends BasicMapper<TSysParameter> {
    /**
     * 查询系统参数配置
     * @return 参数VO类
     */
    List<TSysParameterVo> queryAll(Map<String, Object> map);
}