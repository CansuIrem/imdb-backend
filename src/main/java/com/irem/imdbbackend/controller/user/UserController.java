package com.irem.imdbbackend.controller.user;

import com.irem.imdbbackend.controller.user.dto.LoginRequest;
import com.irem.imdbbackend.controller.user.dto.SignUpRequest;
import com.irem.imdbbackend.service.dto.ServiceResponse;
import com.irem.imdbbackend.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.irem.imdbbackend.core.mappers.UserMapper.map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Validated
public class UserController {


    private final UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<ServiceResponse> login(@RequestBody LoginRequest request) {
        ServiceResponse response = userService.login(request);

        if (response.getResult())
            return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @CrossOrigin
    @PostMapping("/signUp")
    public ResponseEntity<ServiceResponse> signUp(@Valid @RequestBody SignUpRequest request) {

        ServiceResponse response = userService.signUp(map(request));

        if (response.getResult())
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
