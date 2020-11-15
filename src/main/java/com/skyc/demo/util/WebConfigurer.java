package com.skyc.demo.util;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class WebConfigurer implements WebMvcConfigurer {

    //拦截器省略
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/img/**").addResourceLocations("file:" + "C:/upload/img/");
    }

}

