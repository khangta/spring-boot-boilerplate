package com.example.springbootboilerplate.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Permission permission = handlerMethod.getMethodAnnotation(Permission.class);
        if (permission == null) {
            return true;
        }

        // TODO: Need to add any function to get and handle users

        if (permission.role().equals(PermissionRole.MEMBER)) {
            return true;
        }

        if (permission.role().equals(PermissionRole.ADMIN)) {
            return true;
        }

        throw new AuthenticationException();
    }

    private String extractJwtTokenFromHeader(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            throw new AuthenticationException();
        }

        try {
            return authorization.split(" ")[1];
        } catch (Exception e) {
            throw new AuthenticationException();
        }
    }
}