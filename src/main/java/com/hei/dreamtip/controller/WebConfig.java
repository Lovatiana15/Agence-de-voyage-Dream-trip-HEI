package com.hei.dreamtip.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("api/v1/user")
                .allowedOrigins("https://65d19b9b82ab7200dbb10107--meek-blancmange-2b2fc2.netlify.app")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
