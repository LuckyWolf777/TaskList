package com.task.tasklist.web.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@AllArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final JwtTokenProvider tokenProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();
        String bearerToken = request.getHeader("Authorization");

        logger.info("Request URI: {}");
        System.out.println(path);
        logger.info("Authorization Header: {}");
        System.out.println(bearerToken);

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken = bearerToken.substring(7);
            if (tokenProvider.validateToken(bearerToken)) {
                Authentication authentication = tokenProvider.getAuthentication(bearerToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                logger.warn("Invalid JWT token: {}");
                System.out.println(bearerToken);
            }
        } else {
            logger.warn("Missing JWT token");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}