package com.hero.ms.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <p>
 *  Swagger2接口文档引擎 配置类
 * </p>
 *
 * @Author yejx
 * @Date 2020/5/5
 */
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hero.ms.service"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MS-微服务-业务服务 API 文档")
                .description("MS-微服务-业务服务 API 网关接口，http://127.0.0.1:7013")
                .termsOfServiceUrl("http://127.0.0.1:7011")
                .version("1.0.0")
                .build();
    }

}
