package com.example.cloud_game.dto.user_info;

import lombok.Builder;

@Builder
public class UserInfoResponseDto {
    private String login;

    private String email;

    private String status;
}
