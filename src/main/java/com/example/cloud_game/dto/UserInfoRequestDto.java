package com.example.cloud_game.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class UserInfoRequestDto {

    private String login;

    private String email;

    private String status;
}
