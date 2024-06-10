package com.irem.imdbbackend.controller.user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;


@AllArgsConstructor
@Getter
public class SignUpRequest {

    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    @Size(min = 2)
    private String surname;

    @NotNull
    private String email;

    @NotNull
    @Size(min = 8)
    private String password;

    @NotNull
    private String country;

    @NotNull
    private String city;

}
