package com.cardpay.controller.product;

import com.cardpay.mgt.product.model.TProductInvestPictureDesc;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 产品信息测试类
 * Created by chenkai on 2016/12/8.
 */
public class ProductControllerTest extends TestEnv {

    @Test
    @Ignore
    public void insertProduct() throws Exception {
       MockMultipartFile mockFile = new MockMultipartFile("data", "filename.txt"
                , "text/plain", "some xml".getBytes());
        HashMap<String, String> contentTypeParams = new HashMap<>();
        contentTypeParams.put("boundary", "265001916915724");
        MediaType mediaType = new MediaType("multipart", "orm-data", contentTypeParams);
        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/product/insertProduct")
                .file(mockFile)
                .content(mockFile.getBytes())
                .contentType(mediaType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    @Test
    public void updateProduct() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile("data", "filename.txt"
                , "text/plain", "some xml".getBytes());
        HashMap<String, String> contentTypeParams = new HashMap<>();
        contentTypeParams.put("boundary", "265001916915724");
        MediaType mediaType = new MediaType("multipart", "orm-data", contentTypeParams);
        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/product/updateProduct")
                .file(mockFile)
                .param("id", "1")
                .param("productName", "test")
                .content(mockFile.getBytes())
                .contentType(mediaType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}