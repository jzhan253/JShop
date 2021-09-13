package com.jincreation.JShop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class JShopConfig implements WebMvcConfigurer {

    public void addResourceHandlers(ResourceHandlerRegistry regi){
        regi.addResourceHandler("/upload/**").addResourceLocations("file:D:\\upload\\");
    }
}
