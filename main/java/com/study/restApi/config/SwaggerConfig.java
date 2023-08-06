package com.study.restApi.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public GroupedOpenApi bublicApi() {
		return GroupedOpenApi.builder()
				.group("v1-definition")
				.pathsToMatch("/api/**")
				.build();
	}
	
	@Bean
	public OpenAPI springShopOpenApi() {
		return new OpenAPI()
				.info(new Info().title("REST API TEST")
				.description("RestAPI 명세서입니다.")
				.version("V0.0.1"));
	}
}
