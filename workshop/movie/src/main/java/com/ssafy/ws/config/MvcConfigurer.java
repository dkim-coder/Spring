package com.ssafy.ws.config;

import com.ssafy.ws.interceptor.SessionInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MvcConfigurer implements WebMvcConfigurer {

    private final SessionInterceptor si;

    private String[] patterns = {"/movie/**"};


    // 인터셉터 등록
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(si).addPathPatterns(patterns);
    }
    // END


}
