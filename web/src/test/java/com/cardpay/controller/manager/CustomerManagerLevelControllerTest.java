package com.cardpay.controller.manager;

import com.cardpay.util.TestEnv;
import org.junit.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * 客户经理级别controller测试类
 * @author wangpeng
 */
public class CustomerManagerLevelControllerTest extends TestEnv {
    @Test
    public void getCustomerManagerLevel() throws Exception {
        mockMvc.perform(get("/customermanagerlevel/customerManagerLevelList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}