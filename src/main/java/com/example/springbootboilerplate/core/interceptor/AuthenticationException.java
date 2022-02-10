package com.example.springbootboilerplate.core.interceptor;

import com.example.springbootboilerplate.core.exception.CustomException;
import org.springframework.http.HttpStatus;

public class AuthenticationException extends CustomException {

    public AuthenticationException() {
        super(HttpStatus.UNAUTHORIZED, "AUTH_ERROR", "not authenticated");
    }
}
