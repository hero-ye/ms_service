package com.hero.ms.service;

import com.hero.ms.common.filter.CorsOriginFilter;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Log
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
public class MsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsServiceApplication.class, args);
        log.info("已启动");
    }

    /**
     * 解决跨域（方案二：全局配置）
     */
    @Bean
    public CorsFilter corsFilter() {
        return new CorsOriginFilter().corsFilter();
    }
}
