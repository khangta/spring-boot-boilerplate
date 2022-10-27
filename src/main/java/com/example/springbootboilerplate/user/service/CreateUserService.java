package com.example.springbootboilerplate.user.service;

import com.example.springbootboilerplate.user.domain.converter.UserConverter;
import com.example.springbootboilerplate.user.domain.model.User;
import com.example.springbootboilerplate.user.domain.usecase.CreateUserUsecase;
import com.example.springbootboilerplate.user.dto.CreateUserRequestDto;
import com.example.springbootboilerplate.user.persistence.entity.UserEntity;
import com.example.springbootboilerplate.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUsecase {

    private final UserRepository userRepository;

    @Override
    public User execute(final CreateUserRequestDto dto) {
        UserEntity user = UserEntity.builder()
            .nickname(dto.getNickname())
            .password(dto.getPassword())
            .build();
        userRepository.save(user);
        return UserConverter.from(user);
    }
}
