package com.lascaux.cinemille.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		// generic user
	    auth.inMemoryAuthentication()
	        .withUser("user")
	        .password(encoder.encode("user"))
	        .roles("USER");

	    // Admin user
	    auth.inMemoryAuthentication()
	        .withUser("admin")
	        .password(encoder.encode("admin"))
	        .roles("USER", "ADMIN");
	}

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
            .requestMatchers(PathRequest.toH2Console()).permitAll()
            .requestMatchers("/historic/**").hasRole("ADMIN")
            .requestMatchers("/programming/**").hasAnyRole("ADMIN","USER")
            .requestMatchers("/", "/**").permitAll() 
            ) 
            .formLogin(form -> form.loginPage("/login").permitAll().defaultSuccessUrl("/home"))        
            .headers(headers -> headers.frameOptions().disable())
            .csrf().disable();
        return http.build();
        
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
