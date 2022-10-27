package com.example.springbootboilerplate.user.domain.usecase;

import com.example.springbootboilerplate.user.domain.model.User;
import com.example.springbootboilerplate.user.dto.CreateUserRequestDto;

public interface CreateUserUsecase {

    User execute(final CreateUserRequestDto dto);
}
