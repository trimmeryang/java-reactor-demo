package com.trimmer.demo.configuration;

import com.trimmer.demo.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProductRouter {
    @Bean
    public RouterFunction<ServerResponse> routeProduct(ProductHandler productHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/user").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                productHandler::getProducts
        ).andRoute(
                RequestPredicates.GET("/user/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                productHandler::getProductById
        ).andRoute(
                RequestPredicates.POST("/user").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                productHandler::createProduct
        ).andRoute(
                RequestPredicates.DELETE("/user/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                productHandler::deleteProduct
        );
    }
}
