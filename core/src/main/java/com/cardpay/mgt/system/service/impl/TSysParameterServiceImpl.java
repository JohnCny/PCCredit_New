package com.cardpay.mgt.system.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.system.model.TSysParameter;
import com.cardpay.mgt.system.service.TSysParameterService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * 系统参数配置Service实现类
 *
 * @author chenkai
 *         createTime 2016-12-2016/12/27 10:01
 */
@Lazy
@Service
public class TSysParameterServiceImpl extends BaseServiceImpl<TSysParameter> implements TSysParameterService {
}
