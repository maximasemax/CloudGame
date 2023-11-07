package com.example.cloudGame.controller;

import com.example.cloudGame.DataBase.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo createUserInfo(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public UserInfo updateUserInfo(Long id, UserInfo userInfo) {
        UserInfo existingUserInfo = userInfoRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUserInfo.setLogin(userInfo.getLogin());
        existingUserInfo.setEmail(userInfo.getEmail());
        existingUserInfo.setStatus(userInfo.getStatus());
        existingUserInfo.setLogin(userInfo.getRole().toString());
        return userInfoRepository.save(existingUserInfo);
    }

    public void deleteUserInfo(Long id) {
        UserInfo userInfo = userInfoRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userInfoRepository.delete(userInfo);
    }
}

