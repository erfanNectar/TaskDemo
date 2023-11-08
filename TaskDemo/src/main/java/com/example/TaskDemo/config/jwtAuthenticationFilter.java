package com.example.TaskDemo.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor

public class jwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private  final UserDetailsService userDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHearder=request.getHeader("Autherization");
        final String jwt;
        final String userEmail;
        if(authHearder==null || !authHearder.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }

        jwt=authHearder.substring(7);
        userEmail=jwtService.extractUserName(jwt);
        if(userEmail !=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails=this.userDetailsService.loadUserByUsername(userEmail);
        }

    }
}
