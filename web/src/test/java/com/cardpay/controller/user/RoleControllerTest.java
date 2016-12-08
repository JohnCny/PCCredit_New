package com.cardpay.controller.user;

import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RoleControllerTest extends TestEnv {
    @Test
    public void authorityGroup() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/role?add")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void updatePage() throws Exception {

    }

    @Test
    public void operationList() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

}