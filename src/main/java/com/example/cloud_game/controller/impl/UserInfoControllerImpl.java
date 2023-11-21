package com.example.cloud_game.controller.impl;

import com.example.cloud_game.controller.UserInfoController;
import com.example.cloud_game.dto.user_info.UserInfoRequestDto;
import com.example.cloud_game.dto.user_info.UserInfoResponseDto;
import com.example.cloud_game.service.UserInfoService;
import com.example.cloud_game.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserInfoControllerImpl  implements UserInfoController {


    private final UserInfoService userInfoService;


    @PostMapping
    public UserInfoResponseDto createUserInfo(@RequestBody UserInfoRequestDto userInfoRequestDto) {
        return userInfoService.createUserInfo(userInfoRequestDto);
    }


    @GetMapping
    public UserInfoResponseDto getUserInfo(String login, String status){
        return userInfoService.getUserInfo(login, status);
    }
    @PutMapping("/{id}")
    public UserInfoResponseDto updateUserInfo(@PathVariable Long id, @RequestBody UserInfoRequestDto userInfo) {
        return userInfoService.updateUserInfo(id, userInfo) ;
    }

    @DeleteMapping("/{id}")
    public void deleteUserInfo(@PathVariable Long id) {
        userInfoService.deleteUserInfo(id);
    }
}

