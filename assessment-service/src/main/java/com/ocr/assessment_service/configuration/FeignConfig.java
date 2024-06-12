package com.ocr.assessment_service.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    /**
     * All the requests will contain the basic authentication header.
     */
    @Bean
    public BasicAuthRequestInterceptor mBasicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user", "user");
    }
}
