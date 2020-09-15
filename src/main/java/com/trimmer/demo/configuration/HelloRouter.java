package com.trimmer.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import com.trimmer.demo.handler.HelloHandler;

@Configuration
public class HelloRouter {
    @Bean
    public RouterFunction<ServerResponse> routeHello(HelloHandler helloHander) {
        return RouterFunctions.route(
                RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                helloHander::hello
            );
    }
}
