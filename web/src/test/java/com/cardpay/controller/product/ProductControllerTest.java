package com.cardpay.controller.product;

import com.cardpay.mgt.product.model.TProductInvestPictureDesc;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * 产品信息测试类
 * Created by chenkai on 2016/12/8.
 */
public class ProductControllerTest extends TestEnv {
    private TProductInvestPictureDesc tProductInvestPictureDesc = new TProductInvestPictureDesc();

    @Test
    @Ignore
    public void insertProduct() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile("data", "filename.txt"
                , "text/plain", "some xml".getBytes());
        HashMap<String, String> contentTypeParams = new HashMap<>();
        contentTypeParams.put("boundary", "265001916915724");
        MediaType mediaType = new MediaType("multipart", "orm-data", contentTypeParams);
        mockMvc.perform(post("/product/insertProduct")
                .param("id", "1")
                .param("productName", "测试产品")
                .param("orgIds", "1,2,3,4")
                .content(mockFile.getBytes())
                .contentType(mediaType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }


}