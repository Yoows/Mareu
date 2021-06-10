package com.lamzone.Mareu.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.lamzone.Mareu.security.ApplicationUserPermission.MEETING_WRITE;
import static com.lamzone.Mareu.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/api/v1/meetings", "/api/v1/meetings/*").permitAll()
                .antMatchers(HttpMethod.GET,"/api/v1/meetings/**").hasRole(EMPLOYEE.name())
                .antMatchers(HttpMethod.POST, "/api/v1/meetings").hasAuthority(MEETING_WRITE.getPermission())
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
                .authorities(EMPLOYEE.geGrantedAuthorities())
                .build();

        UserDetails emma = User.builder()
                .username("emma")
                .password(passwordEncoder.encode("passer"))
                .authorities(ADMIN.geGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(papa, emma);
    }
}