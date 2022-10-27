package com.example.springbootboilerplate.user.controller.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequest {
    @NotNull
    private String nickname;

    @NotNull
    private String password;
}
