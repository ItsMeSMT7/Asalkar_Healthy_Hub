package com.asalkar.healthyhub.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private String email;
    private String contact;
    private String address;
    private String password;
}
