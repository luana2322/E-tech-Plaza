package com.admin_module.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	
	@Bean
    public SecurityFilterChain securityFilterChain	(HttpSecurity http) throws Exception {
		
		http.authorizeRequests(
   			  authorize->authorize
   			  .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
   			  .requestMatchers(HttpMethod.OPTIONS,"/**/**").permitAll()
  		        .requestMatchers("/*","/*/*").permitAll()
	         .anyRequest().authenticated())
   	  
	          .formLogin(login->login
	          .loginPage("/login")
	          .usernameParameter("email")
           .passwordParameter("password")
	          .loginProcessingUrl("/do-login")
	          .defaultSuccessUrl("/index",true)
	          .failureUrl("/login?error=true")
	          .permitAll())
	          
	          .logout(logout->logout
	          .logoutSuccessUrl("/login?logout")
	          .invalidateHttpSession(true)
	          .deleteCookies("JSESSIONID")
	          .permitAll())
	        .rememberMe(remember->remember.key("aaa"));

        return http.build();
    }  
	
	   @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	    	return (web)->web.ignoring().requestMatchers("/images/**",
	    												 "/css/**",
	    												 "/fonts/**",
	    												 "/img/**",
	    												 "/js/**",
	    												 "/scss/**",
	    												 "/vendors/**",
	    												 "/gulpfile.js",
	    												 "/package.json",
	    												 "/package-lock.json");
	    }
}
