package com.hei.dreamtip.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsFilter {
    public CorsFilter(UrlBasedCorsConfigurationSource source) {
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Autorise toutes les origines, méthodes, et en-têtes (à ajuster selon vos besoins)
        config.addAllowedOrigin("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");

        source.registerCorsConfiguration("/**", config);

        // Utilisez l'objet UrlBasedCorsConfigurationSource comme source pour CorsFilter
        return new CorsFilter(source);
    }
}
