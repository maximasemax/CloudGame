package com.example.cloud_game.service;

import com.example.cloud_game.dto.UserInfoRequestDto;
import com.example.cloud_game.dto.UserInfoResponseDto;
import com.example.cloud_game.repository.UserInfoRepository;
import com.example.cloud_game.entity.UserInfo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {


    private final UserInfoRepository userInfoRepository;

    public UserInfoResponseDto createUserInfo(UserInfoRequestDto userInfo) {
        UserInfo userInfoEntity = new UserInfo();
        userInfoEntity.setEmail(userInfo.getEmail());
        userInfoEntity.setStatus(userInfo.getStatus());
        userInfoEntity.setLogin(userInfo.getLogin());
        UserInfo result = userInfoRepository.save(userInfoEntity);
        return UserInfoResponseDto.builder()
                .email(result.getEmail())
                .login(result.getLogin())
                .status(result.getStatus())
                .build();
    }

    public UserInfoResponseDto getUserInfo(String login,String status){
        UserInfo userInfoEntity = userInfoRepository.findByLoginAndStatus(login,status).orElseThrow(() ->
                new EntityNotFoundException("User not found"));
        return UserInfoResponseDto.builder()
                .login(userInfoEntity.getLogin())
                .status(userInfoEntity.getStatus())
                .email(userInfoEntity.getEmail())
                .build();
    }

    public UserInfo updateUserInfo(Long id, UserInfo userInfo) {
        UserInfo existingUserInfo = userInfoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User not found"));
        existingUserInfo.setLogin(userInfo.getLogin());
        existingUserInfo.setEmail(userInfo.getEmail());
        existingUserInfo.setStatus(userInfo.getStatus());
        existingUserInfo.setLogin(userInfo.getRoles().toString());
        return userInfoRepository.save(existingUserInfo);
    }

    public void deleteUserInfo(Long id) {
        UserInfo userInfo = userInfoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User not found"));
        userInfoRepository.delete(userInfo);
    }
}

