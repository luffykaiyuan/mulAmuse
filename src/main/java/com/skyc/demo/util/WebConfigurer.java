package com.skyc.demo.util;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * 文件获取配置
 * @author luffykaiyuan
 * @date 2020/11/22 11:35
 * @return
 */
@SpringBootConfiguration
public class WebConfigurer implements WebMvcConfigurer {

    //拦截器省略
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/img/**").addResourceLocations("file:" + "C:/upload/img/");
    }

}

