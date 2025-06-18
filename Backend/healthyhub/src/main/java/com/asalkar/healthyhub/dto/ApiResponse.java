package com.asalkar.healthyhub.dto;

public class ApiResponse {
    private boolean success;
    private String message;

    public ApiResponse() {}

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getters and setters
}
