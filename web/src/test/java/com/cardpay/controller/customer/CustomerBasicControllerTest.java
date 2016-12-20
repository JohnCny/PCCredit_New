package com.cardpay.controller.customer;

import com.cardpay.util.TestEnv;
import org.junit.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/**
 * 客户基本信息controller单元测试
 * @author wangpeng
 */
public class CustomerBasicControllerTest extends TestEnv {
    @Test
    public void getCertList() throws Exception {
        mockMvc.perform(get("/customerbasic/certList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void getEducationDegreeList() throws Exception {
        mockMvc.perform(get("/customerbasic/educationDegreeList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void getMarriageStatusList() throws Exception {
        mockMvc.perform(get("/customerbasic/marriageStatusList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void getCustomerStatusList() throws Exception {
        mockMvc.perform(get("/customerbasic/customerStatusList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void getProspectiveCustomers() throws Exception {
        mockMvc.perform(get("/customerbasic/prospectiveCustomers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void validate() throws Exception {
        mockMvc.perform(get("/customerbasic/idCardExist"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}