package com.example.springbootboilerplate.user.domain.converter;

import com.example.springbootboilerplate.user.domain.model.User;
import com.example.springbootboilerplate.user.persistence.entity.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static User from(final UserEntity user) {
        if (user == null) {
            return null;
        }

        return User.builder()
            .id(user.getId())
            .nickname(user.getNickname())
            .password(user.getPassword())
            .build();
    }

    public static UserEntity to(final User user) {
        if (user == null) {
            return null;
        }

        return UserEntity.builder()
            .nickname(user.getNickname())
            .password(user.getPassword())
            .build();
    }
}
