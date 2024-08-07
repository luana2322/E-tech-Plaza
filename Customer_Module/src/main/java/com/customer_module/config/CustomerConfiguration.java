package com.customer_module.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@ComponentScan(basePackages = "com.example.core_module")
@Order(1)
@Profile("development")
public class CustomerConfiguration {

  
    @Bean
    public SecurityFilterChain securityFilterChain	(HttpSecurity http) throws Exception {

		http.authorizeRequests((authorize) -> {
					((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)
							((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)authorize.requestMatchers(HttpMethod.OPTIONS, new String[]{"/**"}))
									.permitAll()
									.requestMatchers(HttpMethod.POST))
									.permitAll().requestMatchers(new String[]{"/*", "/*/*"}))
									.permitAll()
									.anyRequest())
							.authenticated();
				})

	          .formLogin(login->login
	          .loginPage("/login")
	          .usernameParameter("customeremail")
            .passwordParameter("customerpassword")
	          .loginProcessingUrl("/do-login")
	          .defaultSuccessUrl("/index",true)
	          .failureUrl("/login?error=true")
	          .permitAll())
	          
	          .logout(logout->logout
	          .logoutSuccessUrl("/login?logout")
	          .invalidateHttpSession(true)
	          .deleteCookies("JSESSIONID")
	          .permitAll())
	        .rememberMe(remember->remember.key("aaa"))
				  .csrf(AbstractHttpConfigurer::disable);

		return (SecurityFilterChain) http.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
    	return (web)->web.ignoring().requestMatchers("/image/**",
    												 "/css/**",
    												 "/fonts/**",
    												 "/img/**",
    												 "/js/**",
    												 "/scss/**",
    												 "/prepros-6.config");
    }
}
