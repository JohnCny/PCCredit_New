package com.cardpay.controller.customer;

import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * 客户基本信息controller单元测试
 *
 * @author yanweichen
 */
public class CustomerBasicControllerTest extends TestEnv {

    @Test
    @Ignore
    public void update() throws Exception {
        mockMvc.perform(put("/customerBasic/")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void queryCustomer() throws Exception {
        mockMvc.perform(put("/customerBasic/customer")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void changeCustomer() throws Exception {
        mockMvc.perform(put("/customerBasic/customerStatus")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    //TODO： 表不存在
    public void getProspectiveCustomers() throws Exception {
        mockMvc.perform(get("/customerBasic/prospectiveCustomers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    //TODO： 表不存在
    public void validate() throws Exception {
        mockMvc.perform(get("/customerBasic/idCardExist")
                .param("identityCard", "123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }


    @Test
    public void newCustomer() throws Exception {

    }

    @Test
    public void returnNewCustomer() throws Exception {

    }

}