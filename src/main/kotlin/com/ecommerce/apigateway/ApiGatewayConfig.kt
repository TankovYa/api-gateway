package com.ecommerce.apigateway

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApiGatewayConfig {

    @Bean
    fun routeLocator(builder: RouteLocatorBuilder): RouteLocator{
        return builder.routes()
            .route("products") {r ->
                r.path("/products/**")
                .uri("http://localhost:5001")
            }
            .route("orders"){r->
                r.path("/orders/**")
                    .uri("http://localhost:5002")
            }
            .route("customers"){r->
                r.path("/customers/**")
                    .uri("http://localhost:5003")
            }
            .build()
    }
}