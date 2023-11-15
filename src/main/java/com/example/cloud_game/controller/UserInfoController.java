package com.example.cloud_game.controller;

import com.example.cloud_game.dto.UserInfoRequestDto;
import com.example.cloud_game.dto.UserInfoResponseDto;
import com.example.cloud_game.entity.UserInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserInfoController {

    UserInfoResponseDto getUserInfo(String login, String status);
    UserInfoResponseDto createUserInfo(@RequestBody UserInfoRequestDto userInfoRequestDto);

    UserInfo updateUserInfo(@PathVariable Long id, @RequestBody UserInfo userInfo);

    void deleteUserInfo(@PathVariable Long id);


}
