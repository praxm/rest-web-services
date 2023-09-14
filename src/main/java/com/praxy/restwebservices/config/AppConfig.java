package com.praxy.restwebservices.config;

import com.praxy.restwebservices.service.UserDaoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserDaoService userDaoService(){
        return new UserDaoService();
    }
}
