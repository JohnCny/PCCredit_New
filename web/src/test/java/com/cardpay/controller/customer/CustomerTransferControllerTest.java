package com.cardpay.controller.customer;

import com.cardpay.mgt.user.model.User;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


/**
 * 客户移交controller测试类
 * @author chenkai
 */
public class CustomerTransferControllerTest extends TestEnv {

    private User user = User.UserBuilder.get().withId(1).build();

    @Test
    @Ignore
    public void getTransferStatus1() throws Exception {
        mockMvc.perform(get("/customerTransfer/customerTransfer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void changeCustomer() throws Exception {

    }

    @Test
    public void queryTransfer() throws Exception {
        setUser(user);
        mockMvc.perform(get("/customerTransfer/queryTransfer")
                .param("status", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }


}