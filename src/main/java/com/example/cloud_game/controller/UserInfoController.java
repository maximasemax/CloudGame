package com.example.cloud_game.controller;

import com.example.cloud_game.dto.user_info.UserInfoRequestDto;
import com.example.cloud_game.dto.user_info.UserInfoResponseDto;
import com.example.cloud_game.entity.UserInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserInfoController {



    UserInfoResponseDto getUserInfo(String login, String status);
    UserInfoResponseDto createUserInfo(@RequestBody UserInfoRequestDto userInfoRequestDto);

    UserInfoResponseDto updateUserInfo(@PathVariable Long id, @RequestBody UserInfoRequestDto userInfo);

    void deleteUserInfo(@PathVariable Long id);


}
