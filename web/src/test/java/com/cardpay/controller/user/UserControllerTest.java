package com.cardpay.controller.user;

import com.cardpay.basic.redis.RedisClient;
import com.cardpay.basic.redis.enums.RedisKeyPrefixEnum;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends TestEnv {

    @Autowired
    private RedisClient redisClient;

    @Test
    public void updatePassword() throws Exception {
        mockMvc.perform(post("/user?updatePassword=1")
                .param("oldPassword", "123").param("newPassword", "321"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void isHaveLoginName() throws Exception {
        mockMvc.perform(get("/user/anon/rankai"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void sendCode() throws Exception {
        mockMvc.perform(post("/user/anon/sendCode?resetPassword=1")
                .param("userId", "1").param("address", "rankai@qkjr.com.cn"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void checkedCode() throws Exception {
        redisClient.set(RedisKeyPrefixEnum.USER, "rankai@qkjr.com.cn", "123456", 5);
        mockMvc.perform(post("/user/anon/checkedCode?resetPassword=1")
                .param("address", "rankai@qkjr.com.cn").param("code", "123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(post("/user/anon/checkedCode?resetPassword=1")
                .param("address", "rankai@qkjr.com.cn").param("code", "654321"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(5009))
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(post("/user/anon/checkedCode?resetPassword=1")
                .param("address", "mayuan@qkjr.com.cn").param("code", "654321"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(5010))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void resetPassword() throws Exception {
        mockMvc.perform(post("/user/anon/1?resetPassword=1")
                .param("password", "654321"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

}