package com.cardpay.basic.common.swagger;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.List;

import static com.google.inject.internal.util.$Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * swagger配置类
 * Created by chenkai on 2016/11/14.
 */
@Configuration
@EnableSwagger2 //启动swagger注解
@EnableWebMvc //非springboot框架需要引入此注解
@ComponentScan(basePackages = {"com.cardpay"})//指定扫描controller路径
public class SwaggerConfig {
    /**
     * 扫描路径
     */
    private static final String DEFAULT_INCLUDE_PATTERN = "/.*";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("快贷 API")
                .termsOfServiceUrl("http://www.cardpay-sh.com/")
                .contact("乾康西安研发中心")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.cardpay"))  // 对api进行监控
                .paths(regex(DEFAULT_INCLUDE_PATTERN))
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class,//输出模型定义时的替换，比如遇到所有LocalDate的字段时，输出成String
                        String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                /*.alternateTypeRules( // 提供了自定义性更强的针对泛型的处理，示例中的代码的意思是将类型DeferredResult>直接解析成类型T
                        newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)))
                .useDefaultResponseMessages(true) //是否使用默认的ResponseMessage， 框架默认定义了一些针对各个HTTP方法时各种不同响应值对应的message
                .globalResponseMessage(RequestMethod.GET, //全局的定义ResponseMessage，示例代码定义GET方法的500错误的消息以及错误模型。注意这里GET方法的所有ResponseMessage都会被这里的定义覆盖
                        newArrayList(new ResponseMessageBuilder()
                                .code(500)
                                .message("500 message")
                                .responseModel(new ModelRef("Error"))
                                .build()))*/
                .securitySchemes(newArrayList(apiKey())) //定义API支持的SecurityScheme，指的是认证方式，支持OAuth、APIkey。P.S. 要让swagger-ui的oauth正常工作，需要定义个SecurityConfiguration的Bean
                .securityContexts(newArrayList(securityContext())) //定义具体上下文路径对应的认证方式
                ;

    }


    private ApiKey apiKey() {
        return new ApiKey("qkjr", "api_key", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(regex("/anyPath.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("qkjr", authorizationScopes));
    }

/*    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration(
                "test-app-client-id",
                "test-app-realm",
                "test-app",
                "apiKey"
        ,"",
        ,""
        ,""
                     ,"");
    }*/

    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(
                "validatorUrl");
    }

}


