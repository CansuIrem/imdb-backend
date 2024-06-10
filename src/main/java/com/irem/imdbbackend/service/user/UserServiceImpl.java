package com.irem.imdbbackend.service.user;

import com.irem.imdbbackend.controller.user.dto.LoginRequest;
import com.irem.imdbbackend.controller.user.dto.SignUpRequest;
import com.irem.imdbbackend.data.entity.User;
import com.irem.imdbbackend.data.repository.UserRepository;
import com.irem.imdbbackend.service.dto.ServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public ServiceResponse login(LoginRequest request) {

        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(request.getPassword(), user.getPassword()))
                return new ServiceResponse(Boolean.TRUE, "Successfully logged in.");
            return new ServiceResponse(Boolean.FALSE, "Wrong password.");
        }
        return new ServiceResponse(Boolean.FALSE, "User does not exists.");
    }

    @Override
    public ServiceResponse signUp(User user) {

        boolean doesUserExist = userRepository.existsByEmail(user.getEmail());

        if (userRepository.existsByEmail(user.getEmail()))
            return new ServiceResponse(Boolean.FALSE, "User already exists with provided email address.");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        log.info("User saved with email: " + user.getEmail() );
        return new ServiceResponse(Boolean.TRUE, "Successfully saved.");
    }
}
