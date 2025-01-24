package com.test.CRUDSpringBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Bean
public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}
@Bean
SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
	http
	   .csrf(csrf->csrf.disable())
	   .authorizeHttpRequests((authorize)->authorize
			   .requestMatchers(AntPathRequestMatcher.antMatcher("/api/users/**")).permitAll()
			  // .requestMatchers(AntPathRequestMatcher.antMatcher("/api/courses/**")).permitAll()
			   .anyRequest().authenticated()
			   )
	           .httpBasic(withDefaults());
	return http.build();
	
}
}
