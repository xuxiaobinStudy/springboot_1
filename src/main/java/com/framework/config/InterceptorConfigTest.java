package com.framework.config;

import com.app.common.config.ApplicationContextUtil;
import com.framework.interceptor.InterceptorTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description TODO
 * @Author acer
 * @Date 2019/9/14 19:28
 **/
@Configuration
public class InterceptorConfigTest implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((InterceptorTest) ApplicationContextUtil.context.getBean("interceptorTest"));
    }
}
