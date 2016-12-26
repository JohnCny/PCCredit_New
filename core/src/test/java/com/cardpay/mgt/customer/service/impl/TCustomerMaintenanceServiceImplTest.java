package com.cardpay.mgt.customer.service.impl;

import com.cardpay.mgt.customer.dao.TCustomerMaintenanceMapper;
import com.cardpay.mgt.customer.model.vo.TCustomerMaintenanceVo;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * 客户维护服务测试类
 *
 * @author chenkai
 *         createTime 2016-12-2016/12/26 10:31
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TCustomerMaintenanceServiceImpl.class})
public class TCustomerMaintenanceServiceImplTest {
    @Mock
    private TCustomerMaintenanceMapper tCustomerMaintenanceDao;

    @InjectMocks
    private TCustomerMaintenanceServiceImpl tCustomerMaintenanceService;


    @Test
    public void queryCustomerByCondition() throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("managerId", 1);
        List<TCustomerMaintenanceVo> tCustomerMaintenanceVos = new ArrayList<TCustomerMaintenanceVo>() {
            {
                add(new TCustomerMaintenanceVo());
            }
        };
        when(tCustomerMaintenanceDao.queryCustomerByCondition(map)).thenReturn(tCustomerMaintenanceVos);
        List<TCustomerMaintenanceVo> maintenanceVos = tCustomerMaintenanceService.queryCustomerByCondition(map);
        assertTrue(maintenanceVos.size() > 0);
    }

}