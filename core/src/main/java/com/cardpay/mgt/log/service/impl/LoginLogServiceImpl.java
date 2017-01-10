package com.cardpay.mgt.log.service.impl;

import com.alibaba.fastjson.JSON;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.log.model.LoginLog;
import com.cardpay.mgt.log.service.LoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;

/**
 * 登陆日志服务实现
 *
 * @author rankai
 *         createTime 2016-12-2016/12/21 17:15
 */
@Service
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog> implements LoginLogService {

    @Override
    public Example pageList(WebRequest request) {
        String search = request.getParameter("search");
        String order = request.getParameter("order");
        Example example = new Example(LoginLog.class);
        if (StringUtils.isNotBlank(order)) {
            String finalOrder = "";
            Map<String, String> map = JSON.parseObject(order, Map.class);
            if (null != map) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    finalOrder = entry.getKey() + " " + entry.getValue();
                    break;
                }
            }
            example.orderBy(finalOrder);
        }
        Map<String, String> map = null;
        if (StringUtils.isNotBlank(search)) {
            map = JSON.parseObject(search, Map.class);
        }
        if (map != null) {
            Example.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(map.get("loginAccount"))) {
                criteria.andEqualTo("LOGIN_ACCOUNT", map.get("loginAccount"));
            }
            if (StringUtils.isNotBlank(map.get("loginOperation"))) {
                criteria.andEqualTo("LOGIN_OPERATION", map.get("loginOperation"));
            }
            if (StringUtils.isNotBlank(map.get("loginTime"))) {
                criteria.andCondition("to_char(LOGIN_TIME,'yyyy-mm-dd')=", map.get("loginTime"));
            }
        }
        return example;
    }
}
