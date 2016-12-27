package com.cardpay.mgt.log.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.log.model.LoginLog;
import org.springframework.web.context.request.WebRequest;
import tk.mybatis.mapper.entity.Example;

/**
 * 登陆日志服务接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/21 17:14
 */
public interface LoginLogService extends BaseService<LoginLog> {

    /**
     * 自定义分页查询
     *
     * @param request WebRequest对象
     * @return
     */
    Example pageList(WebRequest request);
}
