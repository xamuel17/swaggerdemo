package com.sam.swaggerdemo;

import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerdemoApplication.class, args);
	}
	
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.sam.swaggerdemo"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Address book API",
				"Sample API for Sam's tutoriaL",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Samuel Unachukwu", "http://samuna.com", "sam@gmail.com"), 
				"API License", 
				"http://samuel@gmail.com",
				
				Collections.emptyList()
				
			
				);
	}

}
