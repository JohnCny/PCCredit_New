package com.cardpay.basic.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置类
 * Created by chenkai on 2016/11/14.
 */
@Configuration
@EnableSwagger2 //启动swagger注解
@EnableWebMvc //非springboot框架需要引入此注解
@ComponentScan(basePackages ={"com.cardpay"})//指定扫描controller路径
public class SwaggerConfig {

    @Bean
    public Docket customDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.cardpay")) // 对所有api进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("快贷 API")
                .termsOfServiceUrl("http://www.cardpay-sh.com/")
                .contact("乾康西安研发中心")
                .version("1.0")
                .build();
    }
}


