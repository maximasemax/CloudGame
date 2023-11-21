package com.example.cloud_game.exception;

public class CustomUserInfoException extends RuntimeException {
    public CustomUserInfoException(String errorMessage) {
        super(errorMessage);
    }
}
