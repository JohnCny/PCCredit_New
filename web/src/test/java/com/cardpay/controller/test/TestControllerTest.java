package com.cardpay.controller.test;

import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by yanwe on 2016/11/17.
 */
public class TestControllerTest extends TestEnv {

    @Test
    @Ignore
    public void test1() throws Exception {
        mockMvc.perform(post("/test/api/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }
}