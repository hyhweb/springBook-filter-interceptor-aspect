package com.springboot.filterinterceptoraspect.common.config;

import com.springboot.filterinterceptoraspect.common.interceptor.InterceptorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Autowired
    private InterceptorHandler interceptorHandler;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(interceptorHandler);
       // super.addInterceptors(registry);
    }
}
