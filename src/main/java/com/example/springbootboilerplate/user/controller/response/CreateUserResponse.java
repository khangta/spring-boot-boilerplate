package com.example.springbootboilerplate.user.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
public class CreateUserResponse {
    private Long id;
    private String nickname;

    @Builder
    public CreateUserResponse(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
