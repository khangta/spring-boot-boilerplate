package com.example.springbootboilerplate.user.controller;

import com.example.springbootboilerplate.user.controller.request.CreateUserRequest;
import com.example.springbootboilerplate.user.controller.response.CreateUserResponse;
import com.example.springbootboilerplate.user.domain.model.User;
import com.example.springbootboilerplate.user.domain.usecase.CreateUserUsecase;
import com.example.springbootboilerplate.user.dto.CreateUserRequestDto;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserV1Controller {
    private final CreateUserUsecase createUserUsecase;

    @PostMapping("")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid final CreateUserRequest request) {
        CreateUserRequestDto requestDto = CreateUserRequestDto.builder()
            .nickname(request.getNickname())
            .password(request.getPassword())
            .build();
        User user = createUserUsecase.execute(requestDto);
        CreateUserResponse response = CreateUserResponse.builder()
            .id(user.getId())
            .nickname(user.getNickname())
            .build();
        return ResponseEntity.ok(response);
    }
}
