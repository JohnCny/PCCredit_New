package com.cardpay.controller.customertransfer;

import com.cardpay.util.TestEnv;
import org.junit.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


/**
 * 客户移交controller测试类
 * @author wangpeng
 */
public class CustomerTransferControllerTest extends TestEnv {
    @Test
    public void getTransferStatus() throws Exception {
        mockMvc.perform(get("/customertransfer/transferStatusList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}