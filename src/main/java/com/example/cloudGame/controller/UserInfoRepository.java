package com.example.cloudGame.controller;

import com.example.cloudGame.DataBase.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
