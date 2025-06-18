package com.asalkar.healthyhub.dto;

public class SignupRequest {
    private String username;
    private String email;
    private String password;

    // ✅ Add getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // ✅ Add setters (optional for deserialization)
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
