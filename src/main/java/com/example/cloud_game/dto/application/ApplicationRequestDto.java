package com.example.cloud_game.dto.application;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApplicationRequestDto {

    private String name;

    private String description;

    private String cost;


}
