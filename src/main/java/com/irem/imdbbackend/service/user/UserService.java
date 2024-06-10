package com.irem.imdbbackend.service.user;

import com.irem.imdbbackend.controller.user.dto.LoginRequest;
import com.irem.imdbbackend.data.entity.User;
import com.irem.imdbbackend.service.dto.ServiceResponse;

public interface UserService {

    ServiceResponse login(LoginRequest request);
    ServiceResponse signUp(User user);
}
