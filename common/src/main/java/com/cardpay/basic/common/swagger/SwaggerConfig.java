package com.cardpay.basic.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置类
 * Created by chenkai on 2016/11/14.
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages ={"com.cardpay"})//指定扫描路径
public class SwaggerConfig {

    @Bean
    public Docket customDocket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfo(
                "restfule API",
                "API Document管理",
                "V3.8.0",
                "www.baidu.com",
                "我的邮箱",
                "",
                "");
        docket.apiInfo(apiInfo);
        return docket;
    }

    }


