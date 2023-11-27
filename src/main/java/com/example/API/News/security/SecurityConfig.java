package com.example.API.News.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll() // URLs públicas
                .anyRequest().authenticated() // Todas as outras URLs requerem autenticação
                .and()
                .formLogin()
                .loginPage("/login") // Página de login personalizada, se necessário
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();

        return http.build();
    }
}
