package com.example.springbootboilerplate.user.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class User {
    private Long id;
    private String nickname;
    private String password;

    @Builder
    public User(Long id, String nickname, String password) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
    }
}
