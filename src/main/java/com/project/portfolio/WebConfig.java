package com.project.portfolio;
/**
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://portafolio-angular-543.web.app","https://portafolio-angular-543.firebaseapp.com/sobremi")
                .allowedMethods("GET","PUT","POST","DELETE")
                .maxAge(3600);
    }
}**/