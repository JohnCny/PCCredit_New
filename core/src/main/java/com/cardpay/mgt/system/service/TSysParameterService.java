package com.cardpay.mgt.system.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.system.model.TSysParameter;
import com.cardpay.mgt.system.model.vo.TSysParameterVo;

import java.util.List;
import java.util.Map;

/**
 * 系统参数配置Service
 *
 * @author chenkai
 *         createTime 2016-12-2016/12/27 10:00
 */
public interface TSysParameterService extends BaseService<TSysParameter> {
    /**
     * 查询系统参数配置
     * @return 参数VO类
     */
    List<TSysParameterVo> queryAll(Map<String, Object> map);
}
