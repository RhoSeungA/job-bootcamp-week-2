package com.example.memorydatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.memorydatabase.user.db.UserRepository;

@Configuration
public class DataBaseConfig {

    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }
}