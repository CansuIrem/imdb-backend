package com.irem.imdbbackend.core.mappers;

import com.irem.imdbbackend.controller.user.dto.SignUpRequest;
import com.irem.imdbbackend.data.entity.User;

public class UserMapper {

    public static User map(SignUpRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setCountry(request.getCountry());
        user.setCity(request.getCity());

        return user;
    }
}
