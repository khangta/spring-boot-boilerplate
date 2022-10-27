package com.example.springbootboilerplate.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CreateUserRequestDto {
    private String nickname;
    private String password;

    @Builder
    public CreateUserRequestDto(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
