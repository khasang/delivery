package io.delivery.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
<<<<<<< HEAD
=======
import org.springframework.security.core.Authentication;
>>>>>>> origin/feedback
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

<<<<<<< HEAD
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
=======

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
>>>>>>> origin/feedback
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
<<<<<<< HEAD
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

=======
    public void configAuthentication (AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    };
>>>>>>> origin/feedback

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
<<<<<<< HEAD
                .antMatchers("/create", "/del", "/dump", "/ins", "/password", "/secure", "/upd", "/update").access("hasRole('ADMIN')")
                .and().csrf().disable().formLogin().defaultSuccessUrl("/", false);
    }


=======
                .antMatchers("/secure").access("hasRole('ADMIN')")
                .antMatchers("/dump").access("hasRole('ADMIN')")
//                .antMatchers("/admin/*").access("hasRole('ADMIN')")
                .and().csrf().disable().formLogin().defaultSuccessUrl("/", false);
    }

>>>>>>> origin/feedback
}
