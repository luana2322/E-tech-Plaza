package com.ETechPlaza.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class CustomerConfiguration {

	

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public SecurityFilterChain securityFilterChain	(HttpSecurity http) throws Exception {
		  http.authorizeRequests()
	        .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
	         .requestMatchers("/*").permitAll()
	         .requestMatchers("/customer/*").hasAnyAuthority("CUSTOMER")
	          .and()
	          .formLogin()
	          .usernameParameter("username")
              .passwordParameter("password")
	          .loginPage("/login")
	          .loginProcessingUrl("/do-login")
	          .defaultSuccessUrl("/products-logined")
	          .failureUrl("/login?error")
	          .permitAll()
	        .and()
	          .logout()
	          .logoutSuccessUrl("/login?logout")
	          .invalidateHttpSession(true)
	          .deleteCookies("JSESSIONID")
	          .permitAll()
	        .and()
	          .csrf()
	          .disable();


        return http.build();
    }  
}
