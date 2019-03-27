package com.graduation.info.managementinfo.system.config;

import com.graduation.info.managementinfo.system.comment.AllMyExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DateConfig  {

    @Bean
    public AllMyExceptionHandler allExceptionHandler() {
        return new AllMyExceptionHandler();
    }

}
