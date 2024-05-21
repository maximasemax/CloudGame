package com.example.cloud_game.service;

import com.example.cloud_game.dto.application.ApplicationRequestDto;
import com.example.cloud_game.dto.application.ApplicationResponseDto;
import com.example.cloud_game.entity.Application;
import com.example.cloud_game.repository.ApplicationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationResponseDto createApplication(ApplicationRequestDto application) {
        Application applicationEntity = new Application();
        applicationEntity.setName(application.getName());
        applicationEntity.setDescription(application.getDescription());
        applicationEntity.setCost(application.getCost());
        Application result = applicationRepository.save(applicationEntity);
        return ApplicationResponseDto.builder()
                .name(result.getName())
                .description(result.getDescription())
                .cost(result.getCost())
                .build();
    }

    public ApplicationResponseDto getApplication(String name){
        Application applicationEntity = applicationRepository.findByName(name).orElseThrow(() ->
                new EntityNotFoundException("Application not found"));
        return ApplicationResponseDto.builder()
                .name(applicationEntity.getName())
                .description(applicationEntity.getDescription())
                .cost(applicationEntity.getCost())
                .build();
    }

    public ApplicationResponseDto changeCostApplication(Long id, ApplicationRequestDto application) {
        Application applicationEntity = applicationRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Application not found"));
        applicationEntity.setCost(application.getCost());
        Application result = applicationRepository.save(applicationEntity);
        return ApplicationResponseDto.builder()
                .name(result.getName())
                .description(result.getDescription())
                .cost(result.getCost())
                .build();

    }

    public ApplicationResponseDto changeDescriptionApplication(Long id, ApplicationRequestDto application) {
        Application applicationEntity = applicationRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Application not found"));
        applicationEntity.setDescription(application.getDescription());
        Application result = applicationRepository.save(applicationEntity);
        return ApplicationResponseDto.builder()
                .name(result.getName())
                .description(result.getDescription())
                .cost(result.getCost())
                .build();

    }

    public void deleteApplication(Long id) {
        Application applicationEntity = applicationRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Application not found"));
        applicationRepository.delete(applicationEntity);
    }
}
