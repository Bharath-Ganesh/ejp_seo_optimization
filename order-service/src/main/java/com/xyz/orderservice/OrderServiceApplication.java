package com.xyz.orderservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	/**
	 * Used for inter-service calls (e.g. to user-service or resource-service).
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * Swagger/OpenAPI configuration.
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.xyz.orderservice"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private static ApiInfo apiInfo() {
		return new ApiInfo(
				"Order Service",
				"This microservice manages guide distribution orders in the EJP portal.  " +
						"Users with the `USER` role can place orders to receive printed Reentry Guides.  " +
						"Admin users can view all orders, update order status, and assign delivery agents.  " +
						"Endpoints cover creation, retrieval, status updates, and listing of orders.",
				"1.0.0",
				null,             // terms of service URL
				null,             // contact
				null,             // license
				null,             // license URL
				Collections.emptyList()
		);
	}
}
