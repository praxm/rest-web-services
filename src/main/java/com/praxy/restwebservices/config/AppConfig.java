package com.praxy.restwebservices.config;

import com.praxy.restwebservices.repo.UserRepository;
import com.praxy.restwebservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserDaoService userDaoService(@Autowired UserRepository userRepository){
        return new UserDaoService(userRepository);
    }
}
