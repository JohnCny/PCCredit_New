package com.cardpay.controller.customer;

import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * 客户维护controller单元测试
 *@author wangpeng
 */
public class CustomerMaintenanceControllerTest extends TestEnv {
    @Test
    public void getMaintenanceTypeList() throws Exception {
        mockMvc.perform(get("/customerMaintenance/maintenanceTypeList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    //TODO： 表不存在
    public void getMaintenanceList() throws Exception {
        mockMvc.perform(get("/customerMaintenance/maintenanceList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}