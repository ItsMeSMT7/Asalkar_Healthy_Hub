package com.asalkar.healthyhub.service;

import com.asalkar.healthyhub.dto.*;
import com.asalkar.healthyhub.entity.User;
import com.asalkar.healthyhub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ApiResponse registerUser(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return new ApiResponse(false, "Email already registered");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .contact(request.getContact())
                .address(request.getAddress())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
        return new ApiResponse(true, "User registered successfully");
    }

    public ApiResponse loginUser(LoginRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .map(user -> {
                    if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                        return new ApiResponse(true, "Login successful");
                    } else {
                        return new ApiResponse(false, "Invalid password");
                    }
                }).orElse(new ApiResponse(false, "User not found"));
    }
}
