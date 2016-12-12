package com.cardpay.controller.menu;

import com.cardpay.mgt.user.model.User;
import com.cardpay.util.TestEnv;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 菜单Controller测试类
 *
 * Created by yanwe on 2016/11/29.
 */
public class MenuControllerTest extends TestEnv{

    @Test
    public void selectMenuList() throws Exception {
        User user = new User();
        user.setId(2);
        setUser(user);
        mockMvc.perform(get("/menu/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void recursionDelete() throws Exception {
        //有权限删除
        User user = new User();
        user.setId(2);
        setUser(user);
        mockMvc.perform(delete("/menu/recursionDelete").param("id","75"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }
    @Test
    public void recursionDeleteNo() throws Exception {
        //无权限删除
        mockMvc.perform(delete("/menu/recursionDelete").param("id","75"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(5012));
    }

    @Test
    public void selectMenuAndAuthList() throws Exception {
        mockMvc.perform(get("/menu/allAuth"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}