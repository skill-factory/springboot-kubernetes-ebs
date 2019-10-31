package com.springboot.crud.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket apiDocket() {
        ApiInfo apiInfo = new ApiInfo("Employee Service",
                "This is service user to perform CRUD operations on employee database",
                "1.0",
                "",
                "kalyan cherukuru",
                "",
                ""
        );
        return new Docket(DocumentationType.SWAGGER_12)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.crud"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }
}