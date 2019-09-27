package com.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 使用CORS实现跨域
 * @Author acer
 * @Date 2019/9/23 20:18
 **/
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private Logger log = LoggerFactory.getLogger(CorsConfig.class);

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/login/**").allowedOrigins("127.0.0.1:8081");
        System.out.println("配置CORS");
    }
}
