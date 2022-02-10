package com.example.springbootboilerplate.core.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(
        MethodParameter parameter,
        ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest,
        WebDataBinderFactory binderFactory
    ) throws Exception {
        UserInfo userInfo = new UserInfo();
        String authorization = webRequest.getHeader("Authorization");

        if (authorization == null) {
            return userInfo;
        }

        try {
            // TODO: Need to add any function to get and handle users
            userInfo.setId(1L);
        } catch (Exception e) {
            return userInfo;
        }

        return userInfo;
    }
}
