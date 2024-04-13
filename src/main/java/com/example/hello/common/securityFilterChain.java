package com.example.hello.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityFilterChain  {

    @SuppressWarnings("removal")
    @Bean
    protected SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
            .anyRequest()
            .authenticated();
        http
            .formLogin()
            .defaultSuccessUrl("/home",true)
            .permitAll();
        http
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        return http.build();
    }
}
