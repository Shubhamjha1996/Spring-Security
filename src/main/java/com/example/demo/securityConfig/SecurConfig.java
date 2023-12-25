package com.example.demo.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurConfig {

    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails normalUser = User.withUsername("shubham").password(passwordEncoder().encode("password"))
//                .roles("NORMAL").build();
//
//        return new InMemoryUserDetailsManager(normalUser);

        return new CustomUserDetailService();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/home/admin","/home/new")
                .hasRole("ADMIN")
                .and()
                .authorizeHttpRequests().requestMatchers("/home/**")
                .authenticated().and()
                .formLogin().and().build();
        //return httpSecurity.build();
    }
//    .anyRequest()
//                .authenticated()
    // .hasRole("ADMIN")
//                .requestMatchers("/home/newuser")
//                .permitAll()
//                .requestMatchers("/home/public")
//                .permitAll()

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
