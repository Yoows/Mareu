package com.lamzone.Mareu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/v1/meetings", "/api/v1/meetings/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                    .httpBasic();
    }
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails papa = User.builder()
                .username("papa")
                .password("papa")
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(papa);
    }
}