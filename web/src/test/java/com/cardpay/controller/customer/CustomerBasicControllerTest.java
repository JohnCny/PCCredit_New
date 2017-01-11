package com.cardpay.controller.customer;

import com.cardpay.mgt.user.model.User;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * 客户基本信息controller单元测试
 *
 * @author yanweichen
 */
public class CustomerBasicControllerTest extends TestEnv {


    private User user = User.UserBuilder.get().withId(1).build();

    @Test
    public void returnCustomerList() throws Exception {

    }

    @Test
    public void queryCondition() throws Exception {

    }


    @Test
    @Ignore
    public void deleteCustomer() throws Exception {
        setUser(user);
        mockMvc.perform(delete("/api/customerBasic/del/1")
                .param("customerIds", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void returnUpdate() throws Exception {
        mockMvc.perform(get("/api/customerBasic/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void update() throws Exception {
        mockMvc.perform(put("/api/customerBasic/")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void queryCustomer() throws Exception {
        setUser(user);
        mockMvc.perform(put("/api/customerBasic/condition")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }


    @Test
    @Ignore
    public void validate() throws Exception {
        mockMvc.perform(get("/api/customerBasic/idCardExist")
                .param("identityCard", "123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }


    @Test
    @Ignore
    public void newCustomer() throws Exception {
        mockMvc.perform(post("/api/customerBasic")
                .param("cname","测试")
                .param("industry", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void returnNewCustomer() throws Exception {

    }

}