package com.cardpay.controller.customer;

import com.cardpay.mgt.user.model.User;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * 客户基本信息controller单元测试
 *
 * @author chenkai
 */
public class CustomerBasicControllerTest extends TestEnv {

    private User user = User.UserBuilder.get().withId(1).build();

    @Test
    @Ignore
    public void update() throws Exception {
        setUser(user);
        mockMvc.perform(put("/customerBasic")
                .param("id", "1")
                .param("cname", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void queryCustomer() throws Exception {
        mockMvc.perform(get("/customerBasic/customer")
                .param("id", "1")
                .param("cname", "1"))
                .andExpect(view().name("/customer/customer"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @Test
    public void getCertList() throws Exception {
        mockMvc.perform(get("/customerBasic/certList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void getEducationDegreeList() throws Exception {
        mockMvc.perform(get("/customerBasic/educationDegreeList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void getMarriageStatusList() throws Exception {
        mockMvc.perform(get("/customerBasic/marriageStatusList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void getCustomerStatusList() throws Exception {
        mockMvc.perform(get("/customerBasic/customerStatusList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void getProspectiveCustomers() throws Exception {
        mockMvc.perform(get("/customerBasic/prospectiveCustomers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
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
    @Ignore
    public void returnNewCustomer() throws Exception {
    }

}