package com.cardpay.controller.customer;

import com.cardpay.mgt.user.model.User;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * 客户维护controller单元测试
 *@author chenkai
 */
public class CustomerMaintenanceControllerTest extends TestEnv {
    private User user = User.UserBuilder.get().withId(1).build();

    @Test
    @Ignore
    public void insert() throws Exception {
        setUser(user);
        mockMvc.perform(post("/api/customerMaintenance")
                .param("customerCname", "测试"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void getMaintenanceTypeList() throws Exception {
        mockMvc.perform(get("/customerMaintenance/maintenanceTypeList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void getMaintenanceList() throws Exception {
        mockMvc.perform(get("/customerMaintenance/maintenanceList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}