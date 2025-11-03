package com.mediaTech.tournamentTracker;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class SpaRedirectConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // ✅ Match non-API and non-static routes
        registry.addViewController("/{path:^(?!api|error|static|css|js|images|favicon\\.ico$).*$}")
                .setViewName("forward:/index.html");
    }
}