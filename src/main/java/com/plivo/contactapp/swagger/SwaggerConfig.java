package com.plivo.contactapp.swagger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author raghav on 15/11/18.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket api() {

        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        aParameterBuilder.name("x-auth-token").modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue("123456").build();
        List<Parameter> aParameters = new ArrayList<Parameter>();
        aParameters.add(aParameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors
                .basePackage("com.plivo.contactapp.controller"))
            .paths(PathSelectors.any())
            .build()
            .host("ec2-3-17-58-55.us-east-2.compute.amazonaws.com")
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo())
            .consumes(contentTypes())
            .produces(contentTypes())
            .globalOperationParameters(aParameters);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Plivo Contact App")
            .description("Apis for Contact app")
            .version("1.0")
            .contact(new Contact("Plivo dev Team", "https://www.plivo.com",
                "developers@plivo.com"))
            .build();
    }

    private Set<String> contentTypes() {
        Set<String> contentTypes = new HashSet<String>();
        contentTypes.add("application/json");
        return contentTypes;
    }
}
