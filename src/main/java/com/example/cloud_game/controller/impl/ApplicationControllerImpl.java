package com.example.cloud_game.controller.impl;

import com.example.cloud_game.controller.ApplicationController;
import com.example.cloud_game.dto.application.ApplicationRequestDto;
import com.example.cloud_game.dto.application.ApplicationResponseDto;
import com.example.cloud_game.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationControllerImpl implements ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/name")
    public ApplicationResponseDto getApplication(String name) {
        return applicationService.getApplication(name);
    }

    @PostMapping
    public ApplicationResponseDto createApplication(ApplicationRequestDto applicationRequestDto) {
        return applicationService.createApplication(applicationRequestDto);
    }

    @PutMapping("/id, cost")
    public ApplicationResponseDto changeCostApplication(ApplicationRequestDto applicationRequestDto, Long id) {
        return applicationService.changeCostApplication(id, applicationRequestDto);
    }

    @PutMapping("/id, description")
    public ApplicationResponseDto changeDescriptionApplication(ApplicationRequestDto applicationRequestDto, Long id) {
        return applicationService.changeDescriptionApplication(id, applicationRequestDto);
    }

    @DeleteMapping("/id")
    public void deleteApplication(Long id) {
        applicationService.deleteApplication(id);
    }


}
