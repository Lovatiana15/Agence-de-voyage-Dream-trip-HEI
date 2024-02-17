package com.hei.dreamtip.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://65d13095a5c298e8c87c0be4--voyagedream.netlify.app")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
