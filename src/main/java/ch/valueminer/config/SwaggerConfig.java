/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2016.
 */

package ch.valueminer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@ComponentScan(basePackages = "ch.valueminer.api")
@EnableSwagger2
// Loads the spring beans required by the framework
@PropertySource("classpath:swagger.properties")
public class SwaggerConfig {
    @Bean
    ApiInfo apiInfo() {
        return new ApiInfo(
                "ValueMiner Adapter APIs",
                "Adapter-Services for managing Adapters of ValueMiner.",
                "1.0",
                "",
                "",
                "",
                "");
    }

    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }

}
