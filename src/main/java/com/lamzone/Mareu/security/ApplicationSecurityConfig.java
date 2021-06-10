package com.lamzone.Mareu.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.lamzone.Mareu.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/v1/meetings", "/api/v1/meetings/*").permitAll()
                .antMatchers("/api/**").hasRole(EMPLOYEE.name())
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
                .password(passwordEncoder.encode("papa"))
                .roles(EMPLOYEE.name())
                .build();

        UserDetails emma = User.builder()
                .username("emma")
                .password("passer")
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(papa, emma);
    }
}