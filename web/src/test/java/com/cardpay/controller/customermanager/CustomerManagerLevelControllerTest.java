package com.cardpay.controller.customermanager;

import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * 客户经理级别controller测试类
 * @author yanweichen
 */
public class CustomerManagerLevelControllerTest extends TestEnv {
    @Test
    @Ignore
    //TODO： 表不存在
    public void getCustomerManagerLevel() throws Exception {
        mockMvc.perform(get("/customerManagerLevel/customerManagerLevelList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}