package com.fis.lms.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator locator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/books/**")
						.filters(f -> f.rewritePath("/books", "/api/get/books"))
						.uri("lb://Book"))
				.route(p -> p.path("/subscriptions/**")
						.filters(f -> f.rewritePath("/subscriptions", "/api/get/subscriptions"))
						.uri("lb://Subscription"))
				.route(p -> p.path("/post/subscription/**")
						.filters(f -> f.rewritePath("/post/subscription", "/api/post/subscription"))
						.uri("lb://Subscription"))
				.route(p -> p.path("/subscription/**")
						.filters(f -> f.rewritePath("/subscription/return", "/api/post/returns"))
						.uri("lb://Subscription"))
				.route(p -> p.path("/books/**")
						.filters(f -> f.rewritePath("/books/(?<segment>.*)", "/api/get/books/${segment}"))
						.uri("lb://Book"))
				.build();
	}
}
