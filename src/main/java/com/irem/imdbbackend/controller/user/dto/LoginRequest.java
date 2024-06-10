package com.irem.imdbbackend.controller.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginRequest {

    @NotNull
    private String email;
    @Size(min = 8)
    @NotNull
    private String password;
}
