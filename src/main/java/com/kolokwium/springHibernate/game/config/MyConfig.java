package com.kolokwium.springHibernate.game.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfig {
    @Primary
    @Bean(name = "returnTrue")
    boolean getBoolean(){
        return true;
    }
}
