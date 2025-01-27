package com.biblioteca.movies.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class FeignClientConfig {

    @Value("${omdb.apikey}")
    private String apiKey;

    @Bean
    RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            requestTemplate.query("apikey", apiKey);
        };
    }
}
