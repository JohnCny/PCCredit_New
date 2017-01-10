package com.cardpay.controller.user;

import com.cardpay.basic.redis.RedisClient;
import com.cardpay.basic.redis.enums.RedisKeyPrefixEnum;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends TestEnv {

    @Autowired
    private RedisClient redisClient;

    @Test
    @Ignore
    public void pageList() throws Exception {

        String search = "{\"username\":\"rankai\"}";
        String order = "{\"id\":\"desc\"}";
        mockMvc.perform(get("/user/pageList")
                .param("start", "1").param("length", "10").param("search", search).param("order", order))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(get("/user/jsonList")
                .param("start", "1").param("length", "10"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(get("/user/jsonList")
                .param("start", "1").param("length", "10").param("search", search))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(get("/user/jsonList")
                .param("start", "1").param("length", "10").param("order", order))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Ignore
    public void updatePassword() throws Exception {
        mockMvc.perform(post("/user/updatePassword")
                .param("oldPassword", "123").param("newPassword", "321"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Ignore
    public void isHaveLoginName() throws Exception {
        mockMvc.perform(get("/user/resetPassword/rankai"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Ignore
    public void sendCode() throws Exception {
        mockMvc.perform(post("/user/resetPassword/sendCode")
                .param("userId", "1").param("address", "rankai@qkjr.com.cn"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(post("/user/resetPassword/sendCode")
                .param("userId", "1").param("address", "mayuan@qkjr.com.cn"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(5014))
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(post("/user/resetPassword/sendCode")
                .param("userId", "1").param("address", "rankai"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(5013))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Ignore
    public void checkedCode() throws Exception {
        redisClient.set(RedisKeyPrefixEnum.USER, "rankai@qkjr.com.cn", "123456", 5);
        mockMvc.perform(post("/user/resetPassword/checkedCode")
                .param("address", "rankai@qkjr.com.cn").param("code", "123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(post("/user/resetPassword/checkedCode")
                .param("address", "rankai@qkjr.com.cn").param("code", "654321"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(5009))
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(post("/user/resetPassword/checkedCode")
                .param("address", "mayuan@qkjr.com.cn").param("code", "654321"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(5010))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Ignore
    public void resetPassword() throws Exception {
        redisClient.set(RedisKeyPrefixEnum.USER, "aaaaaaaaaaaaaaaa", "checkedCode", 5);
        mockMvc.perform(post("/user/resetPassword/aaaaaaaaaaaaaaaa")
                .param("password", "654321").param("userId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());

        mockMvc.perform(post("/user/resetPassword/bbbbbbbbbbbbbbbb")
                .param("password", "654321").param("userId", "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(5021))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Ignore
    public void isIdCard() throws Exception {
        mockMvc.perform(post("/user/isIdCard")
                .param("isIdCard", "431381198809122734"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andDo(MockMvcResultHandlers.print());
    }

}