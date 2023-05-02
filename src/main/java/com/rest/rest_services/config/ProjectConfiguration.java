package com.rest.rest_services.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Configuration
public class ProjectConfiguration {

    private final Environment env;

    public ProjectConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthenticationInterceptor(){
        return new BasicAuthRequestInterceptor("admin@gmail.com", "admin");
    }

    @Bean
    public RestTemplate restTemplate(){
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder.basicAuthentication("admin@gmail.com", "admin").build();

    }
}
