package com.ocr.gateway_service.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("patient-service", route -> route.path("/patient-service/**")
                        .uri("lb://patient-service"))
                .route("client-service", route -> route.path("/client-service/**")
                        .uri("lb://client-service"))
                .build();
    }

}
