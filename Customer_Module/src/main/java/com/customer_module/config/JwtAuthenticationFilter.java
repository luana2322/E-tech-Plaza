package com.customer_module.config;




import com.auth0.jwt.JWT;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.core_module.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private final CustomerRepository customerRepository;
	@Value("${secret.key}")
	private String secretkey;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authorizationHeader = request.getHeader(AUTHORIZATION);
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {
				String token = authorizationHeader.substring("Bearer ".length());
				Algorithm algorithm = Algorithm.HMAC256(secretkey.getBytes());			
				JWTVerifier verifier = JWT.require(algorithm).build(); 
				DecodedJWT decodedJWT = verifier.verify(token);
				String email = decodedJWT.getSubject();
				customerRepository.findBycustomeremail(email).orElseThrow(() -> new Exception("Invalid Token"));

				String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
				Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
				Arrays.stream(roles).forEach(role -> {
					authorities.add(new SimpleGrantedAuthority(role));
				});

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						email, null, authorities);
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
				
				filterChain.doFilter(request, response);
			} catch (Exception e) {
				
				ErrorRespone errorRespone = new ErrorRespone(FORBIDDEN, e.getMessage());
				response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
				response.setStatus(errorRespone.getStatusCodeValue());
				new ObjectMapper().writeValue(response.getOutputStream(), errorRespone);

			}
		} else {
			filterChain.doFilter(request, response);	
			
		}
	}

}
