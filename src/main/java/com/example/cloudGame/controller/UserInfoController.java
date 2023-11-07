package com.example.cloudGame.controller;

import com.example.cloudGame.DataBase.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping
    public UserInfo createUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.createUserInfo(userInfo);
    }

    @PutMapping("/{id}")
    public UserInfo updateUserInfo(@PathVariable Long id, @RequestBody UserInfo userInfo) {
        return userInfoService.updateUserInfo(id, userInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteUserInfo(@PathVariable Long id) {
        userInfoService.deleteUserInfo(id);
    }
}

