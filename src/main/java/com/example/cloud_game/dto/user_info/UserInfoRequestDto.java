package com.example.cloud_game.dto.user_info;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class UserInfoRequestDto {

    private String login;

    private String email;

    private String status;
}
