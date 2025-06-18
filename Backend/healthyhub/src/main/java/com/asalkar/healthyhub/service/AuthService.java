package com.asalkar.healthyhub.service;

import com.asalkar.healthyhub.dto.*;
import com.asalkar.healthyhub.model.User;
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
        if (userRepository.findByEmail(request.getEmail()) != null) {
            return new ApiResponse(false, "Email already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
        return new ApiResponse(true, "User registered successfully");
    }

    public ApiResponse loginUser(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new ApiResponse(true, "Login successful");
        } else {
            return new ApiResponse(false, "Invalid email or password");
        }
    }
}
