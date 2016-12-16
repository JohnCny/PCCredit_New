package com.cardpay.controller.user;

import com.cardpay.mgt.user.model.Role;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RoleControllerTest extends TestEnv {

    @Test
    public void authorityGroup() throws Exception {
        mockMvc.perform(get("/role/add"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void add() throws Exception {
        Role role = new Role();
        role.setRoleName("test");
        mockMvc.perform(post("/role/add")
                .param("authorityId", "1").param("authorityId", "2")
                .requestAttr("role", role))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updatePage() throws Exception {
        mockMvc.perform(get("/role/1/page"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void operationList() throws Exception {
        mockMvc.perform(get("/role/风险控制/update"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(get("/role?roleId=1&oldAuthorityId=1&newAuthorityId=2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(get("/role?roleId=1&oldAuthorityId=3&newAuthorityId=4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

}