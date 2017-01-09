package com.cardpay.controller.login;

import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class LogonControllerTest extends TestEnv {

    @Test
    @Ignore
    public void login() throws Exception {

        mockMvc.perform(post("/logon/login")
                .param("userName", "rankai"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(5018))
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(post("/logon/login")
                .param("userName", "rankai").param("password", "123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Ignore
    public void unauthorized() throws Exception {
        mockMvc.perform(get("/logon/unauthorized"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(5012))
                .andDo(MockMvcResultHandlers.print());
    }

}