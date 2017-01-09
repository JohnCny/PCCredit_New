package com.cardpay.controller.customer;

import com.cardpay.mgt.user.model.User;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


/**
 * 客户移交controller测试类
 *
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
        mockMvc.perform(put("/api/customerTransfer")
                .param("customerIds", "1,2")
                .param("status", "0")
                .param("reason", "test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void queryTransfer() throws Exception {
        setUser(user);
        mockMvc.perform(get("/customerTransfer/queryTransfer")
                .param("status", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }


    @Test
    @Ignore
    public void queryCustomer() throws Exception {
        setUser(user);
        mockMvc.perform(get("/customerTransfer")
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}