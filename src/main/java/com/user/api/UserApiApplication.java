package com.user.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.modelmapper.ModelMapper;


@EnableJpaRepositories
@SpringBootApplication
public class UserApiApplication {

    @Bean
    public ModelMapper ModelMapper() {
        return new ModelMapper();
        
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }

}
