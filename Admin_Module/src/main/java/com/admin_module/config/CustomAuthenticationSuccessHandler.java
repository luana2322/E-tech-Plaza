//package com.admin_module.config;
//
//
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import java.io.IOException;
//import java.util.Collection;
//
//public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//
//        for (GrantedAuthority authority : authorities) {
//            if (authority.getAuthority().equals("ADMIN")) {
//                response.sendRedirect("/*");
//                return;
//            } else if (authority.getAuthority().equals("ROLE_CUSTOMER")) {
//                response.sendRedirect("/customer/index");
//                return;
//            }
//        }
//
//        // Mặc định nếu không tìm thấy vai trò phù hợp
//        response.sendRedirect("/default/index");
//    }
//}