package com.cardpay.basic.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.google.inject.internal.util.$Lists.newArrayList;
import static java.util.Arrays.asList;
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
                .description("快贷接口文档")
                /*.contact(new Contact("乾康西安研发中心", "http:/baidu.com", "123@qq.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")*/
                .version("1.0.0")
                .build();
    }

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securitySchemes(asList(
                        new OAuth(
                                "petstore_auth",
                                asList(new AuthorizationScope("write_pets", "modify pets in your account"),
                                        new AuthorizationScope("read_pets", "read your pets")),
                                Arrays.asList(new ImplicitGrant(new LoginEndpoint("http://petstore.swagger.io/api/oauth/dialog"), "tokenName"))
                        ),
                        new ApiKey("mykey", "api_key", "header")
                ))
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.cardpay"))//对api进行监控 RequestHandlerSelectors.withClassAnnotation(RestController.class)
                .paths(regex(DEFAULT_INCLUDE_PATTERN))
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)//输出模型定义时的替换，比如遇到所有LocalDate的字段时，输出成String
                .genericModelSubstitutes(ResponseEntity.class) //直接解析成泛型类型，比如说ResponseEntity<T>，应该直接输出成类型T
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
                                .build()))*//*
                *//*.enableUrlTemplating(true)
                .globalOperationParameters( //给所有方法添加自定义参数
                        newArrayList(new ParameterBuilder()
                                .name("someGlobalParameter")
                                .description("Description of someGlobalParameter")
                                .modelRef(new ModelRef("string"))
                                .parameterType("query")
                                .required(true)
                                .build()))*/
               // .securitySchemes(newArrayList(apiKey())) //定义API支持的SecurityScheme，指的是认证方式，支持OAuth、APIkey。P.S. 要让swagger-ui的oauth正常工作，需要定义个SecurityConfiguration的Bean
                .securityContexts(newArrayList(securityContext())) //定义具体上下文路径对应的认证方式
                ;
    }

  /*  @Autowired
    private TypeResolver typeResolver;

    private ApiKey apiKey() {
        return new ApiKey("mykey", "api_key", "header");
    }*/

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("mykey", authorizationScopes));
    }

    @Bean
    SecurityConfiguration security() {
        return new SecurityConfiguration(
                "swagger-ui",
                "test-app-client-secret",
                "test-app-realm",
                "test-app",
                "apiKey",
                ApiKeyVehicle.HEADER,
                "mykey",
                "," );
    }


    @Bean
    UiConfiguration uiConfig() {
        return new UiConfiguration(
                "http://localhost/swagger-ui.html",// url
                "none",       // docExpansion          => none | list
                "alpha",      // apiSorter             => alpha
                "schema",     // defaultModelRendering => schema
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
                false,        // enableJsonEditor      => true | false
                true);     // showRequestHeaders    => true | fals);
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver commonsMultipartResolver()
    { return new CommonsMultipartResolver(); }
}


