package com.ssafy.config;

import com.ssafy.interceptor.PerformanceInterceptor;
import com.ssafy.interceptor.SessionInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfigurer implements WebMvcConfigurer {
    private final PerformanceInterceptor pi;
    private final SessionInterceptor si;
    @Value("${spring.servlet.multipart.location}")
    String filePath;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(pi);
        registry.addInterceptor(si).addPathPatterns("/auth/**").excludePathPatterns("/auth/help");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/auth/help").setViewName("help/auth-help");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + filePath + "/");
    }
}
