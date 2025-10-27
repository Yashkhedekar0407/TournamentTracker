package com.mediaTech.tournamentTracker;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpaRedirectConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // ✅ Forward all non-API requests (without a dot) to index.html
        registry.addViewController("/{path:^(?!api$).*$}")
                .setViewName("forward:/index.html");
    }
}
