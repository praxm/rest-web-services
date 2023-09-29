package com.praxy.restwebservices.config;

import com.praxy.restwebservices.repo.UserRepository;
import com.praxy.restwebservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

    @Bean
    public UserDaoService userDaoService(@Autowired UserRepository userRepository){
        return new UserDaoService(userRepository);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        httpSecurity.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
