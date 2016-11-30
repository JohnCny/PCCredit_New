package com.cardpay.controller.menu;

import com.cardpay.util.TestEnv;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by yanwe on 2016/11/29.
 */
public class MenuControllerTest extends TestEnv{

    @Test
    public void selectMenuList() throws Exception {
        mockMvc.perform(get("/menu/all").param("level","3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void recursionDelete() throws Exception {
        mockMvc.perform(get("/menu/recursionDelete").param("id","73"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}