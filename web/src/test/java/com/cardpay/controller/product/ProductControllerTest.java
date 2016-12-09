package com.cardpay.controller.product;

import com.cardpay.mgt.product.model.TProductInvestPictureDesc;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
        TProductInvestPictureDesc tProductInvestPictureDesc = new TProductInvestPictureDesc();
        tProductInvestPictureDesc.setId(1);
        tProductInvestPictureDesc.setIsNeed(1);
        tProductInvestPictureDesc.setPritureDescription("1");
        tProductInvestPictureDesc.setProductId(1);
        TProductInvestPictureDesc tProductInvestPictureDesc2 = new TProductInvestPictureDesc();
        tProductInvestPictureDesc2.setId(2);
        tProductInvestPictureDesc2.setIsNeed(2);
        tProductInvestPictureDesc2.setPritureDescription("2");
        tProductInvestPictureDesc2.setProductId(2);
        List<TProductInvestPictureDesc> list = new ArrayList<TProductInvestPictureDesc>(){
            {
                add(tProductInvestPictureDesc);
                add(tProductInvestPictureDesc2);
            }
        };
        mockMvc.perform(post("/product/insertProduct")
                .param("id", "1")
                .param("productName", "测试产品")
                .param("orgIds", "1,2,3,4")
                .param("TProductInvestPictureDescList", list.toString())
                .content(mockFile.getBytes())
                .contentType(mediaType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}