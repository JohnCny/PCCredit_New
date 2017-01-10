package com.cardpay.controller.organization;

import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by chenkai on 2016/11/30.
 */
public class OrganizationControllerTest extends TestEnv {

    @Test
    @Ignore
    public void changeQueryOrganization() throws Exception {
        mockMvc.perform(get("/organization/movementOrganization").param("level", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void queryOrganization() throws Exception {
        mockMvc.perform(get("/organization/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void deleteOrganization() throws Exception {
        mockMvc.perform(delete("/organization/").param("id", "2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    @Ignore
    public void insertOrganization() throws Exception {
        mockMvc.perform(post("/organization/")
                .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}