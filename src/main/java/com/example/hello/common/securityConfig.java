package com.example.hello.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;


@Configuration
@EnableWebSecurity
@Slf4j
public class securityConfig  {

    @SuppressWarnings("removal")
    @Bean
    protected SecurityFilterChain SecurityChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
            .requestMatchers("/registUser").permitAll()
            .requestMatchers("/registUserSuc").permitAll()
            .anyRequest()
            .authenticated();
        http
            .formLogin().permitAll()
            .loginPage("/login")
            .defaultSuccessUrl("/home",true);
        http
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        http
            .logout().permitAll();
        return http.build();
    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        log.info("password:{}",encoder.encode("pass"));
        return encoder;
    }
}
