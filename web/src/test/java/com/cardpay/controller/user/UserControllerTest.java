package com.cardpay.controller.user;

import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends TestEnv {

    @Test
    public void updatePassword() throws Exception {
        mockMvc.perform(post("/user?updatePassword=1")
                .param("oldPassword", "123").param("newPassword", "321"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

}