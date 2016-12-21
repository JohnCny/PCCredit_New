package com.cardpay.controller.customer;

import com.cardpay.util.TestEnv;
import org.junit.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


/**
 * 客户移交controller测试类
 * @author yanweichen
 */
public class CustomerTransferControllerTest extends TestEnv {
    @Test
    public void getTransferStatus() throws Exception {
        mockMvc.perform(get("/customerTransfer/customerTransfer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}