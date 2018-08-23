package com.github.rhythmdiao;

import com.github.rhythmdiao.interceptor.InnerControllerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author rhyth
 */
@Configuration
public class WechatConfigurer implements WebMvcConfigurer {
    @Resource
    private InnerControllerInterceptor innerControllerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(innerControllerInterceptor).addPathPatterns("/echo");
    }
}
