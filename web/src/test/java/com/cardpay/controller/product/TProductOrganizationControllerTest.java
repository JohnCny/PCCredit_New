package com.cardpay.controller.product;

import com.cardpay.util.TestEnv;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * 产品机构关联表测试类
 * Created by chenkai on 2016/12/12.
 */
public class TProductOrganizationControllerTest extends TestEnv {


    @Test
    public void insertProductOrganization() throws Exception {
        mockMvc.perform(post("/productOrganization/insertProductOrganization").param("productId","2")
        .param("orgIds", "2,3,4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void deleteProductOrganization() throws Exception {
        mockMvc.perform(delete("/productOrganization/deleteProductOrganization").param("productId","2")
                .param("orgIds", "2,3,4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}