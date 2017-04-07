package io.delivery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/").permitAll().
                antMatchers("/secure").access("hasRole('ADMIN')").
                antMatchers("/users").access("hasRole('USER')").
                antMatchers("/create").access("hasRole('ADMIN')").
                antMatchers("/delete").access("hasRole('ADMIN')").
                antMatchers("/backup").access("hasRole('ADMIN')").
                antMatchers("/users").access("hasRole('ADMIN') or hasRole('USER')").
                antMatchers("/insert").access("hasRole('ADMIN') or hasRole('USER')").
                antMatchers("/update").access("hasRole('ADMIN') or hasRole('USER')").
                and().csrf().disable().formLogin().defaultSuccessUrl("/", false);
    }


}
