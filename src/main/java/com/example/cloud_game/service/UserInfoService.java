package com.example.cloud_game.service;

import com.example.cloud_game.dto.user_info.UserInfoRequestDto;
import com.example.cloud_game.dto.user_info.UserInfoResponseDto;
import com.example.cloud_game.exception.CustomUserInfoException;
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
                new CustomUserInfoException("User not found"));
        return UserInfoResponseDto.builder()
                .login(userInfoEntity.getLogin())
                .status(userInfoEntity.getStatus())
                .email(userInfoEntity.getEmail())
                .build();
    }

    public UserInfoResponseDto updateUserInfo(Long id, UserInfoRequestDto userInfo) {
        UserInfo userInfoEntity = userInfoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User not found"));
        userInfoEntity.setLogin(userInfo.getLogin());
        userInfoEntity.setEmail(userInfo.getEmail());
        userInfoEntity.setStatus(userInfo.getStatus());
        UserInfo result = userInfoRepository.save(userInfoEntity);

        return UserInfoResponseDto.builder()
                .login(result.getLogin())
                .email(result.getEmail())
                .status(result.getStatus())
                .build();
    }

    public void deleteUserInfo(Long id) {
        UserInfo userInfo = userInfoRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User not found"));
        userInfoRepository.delete(userInfo);
    }
}


//TODO сделать 404 ошибку вмсето рантайм
//TODO Почитать про @ExceptionHandler и @ControllerAdvice