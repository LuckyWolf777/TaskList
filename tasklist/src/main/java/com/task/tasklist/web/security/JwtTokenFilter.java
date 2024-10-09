package com.task.tasklist.web.security;

import com.task.tasklist.model.exception.ResourceNotFoundException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@AllArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final JwtTokenProvider tokenProvider;

    //1
    //    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        String bearerToken = ((HttpServletRequest)servletRequest).getHeader("Authorization");
//        logger.info("Authorization Header: {}");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            bearerToken = bearerToken.substring(7);
//            logger.info("Extracted Bearer Token: {}");
//        }
//        if (bearerToken != null && tokenProvider.validateToken(bearerToken)) {
//            try {
//                Authentication authentication = tokenProvider.getAuthentication(bearerToken);
//                if (authentication != null) {
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                    logger.info("User authenticated with token: {}");
//                }
//            } catch (ResourceNotFoundException ignore) {
//                logger.error("User not found for token: {}");
//            }
//        } else {
//            logger.warn("Invalid or missing JWT token: {}");
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
    //2
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        String path = request.getRequestURI();
//
//        // Пропускаем запросы на /login, /register, /refresh без проверки токена
//        if (path.startsWith("/api/v1/auth/")) {
//            filterChain.doFilter(servletRequest, servletResponse);
//            return;
//        }
//
//        String bearerToken = request.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            bearerToken = bearerToken.substring(7);
//        }
//        if (bearerToken != null && tokenProvider.validateToken(bearerToken)) {
//            try {
//                Authentication authentication = tokenProvider.getAuthentication(bearerToken);
//                if (authentication != null) {
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            } catch (ResourceNotFoundException ignore) {
//                // Обработка исключений
//            }
//        } else {
//            // Логирование отсутствующего или некорректного токена
//            logger.warn("Invalid or missing JWT token");
//        }
//
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
    //3
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        String path = request.getRequestURI();
//
//        // Пропуск определённых маршрутов
//        if (path.startsWith("/api/v1/auth/")) {
//            filterChain.doFilter(servletRequest, servletResponse);
//            return;
//        }
//
//
//        // Обработка JWT токена
//        String bearerToken = request.getHeader("Authorization");
//        if (bearerToken == null) {
//            logger.warn("Authorization header is missing in the request");
//        } else {
//            logger.info("Authorization header received: {}");
//            System.out.println(bearerToken);
//        }
//
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            bearerToken = bearerToken.substring(7);
//            if (tokenProvider.validateToken(bearerToken)) {
//                Authentication authentication = tokenProvider.getAuthentication(bearerToken);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            } else {
//                logger.warn("Invalid JWT token: {}");
//                System.out.println(bearerToken);
//            }
//        } else {
//            logger.warn("Missing JWT token");
//        }
//
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
    //4
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

//погуглить как создать request body с header
}