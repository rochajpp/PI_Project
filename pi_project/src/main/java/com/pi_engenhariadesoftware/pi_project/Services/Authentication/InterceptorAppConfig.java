package com.pi_engenhariadesoftware.pi_project.Services.Authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorAppConfig implements WebMvcConfigurer{
    
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
        .addPathPatterns("/admin", "/setCar", "/rmCar", "/backCar", "/addCar", "/addUser", "/alterUser", "/removeUser");
        
        registry.addInterceptor(new ResetPassInterceptor())
        .addPathPatterns("/setPassForm");
        
    }
}
