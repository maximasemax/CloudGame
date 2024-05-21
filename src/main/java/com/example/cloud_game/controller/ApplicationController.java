package com.example.cloud_game.controller;

import com.example.cloud_game.dto.application.ApplicationRequestDto;
import com.example.cloud_game.dto.application.ApplicationResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface ApplicationController {

    ApplicationResponseDto getApplication(String name);

    ApplicationResponseDto createApplication(@RequestBody ApplicationRequestDto applicationRequestDto);

    ApplicationResponseDto changeCostApplication(@RequestBody ApplicationRequestDto applicationRequestDto, Long id);

    ApplicationResponseDto changeDescriptionApplication(@RequestBody ApplicationRequestDto applicationRequestDto, Long id);

    void deleteApplication(Long id);
}
