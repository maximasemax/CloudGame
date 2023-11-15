package com.example.cloud_game.repository;

import com.example.cloud_game.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    Optional<UserInfo> findByLoginAndStatus(String login, String status);
    @Override
    Optional<UserInfo> findById(Long aLong);
}
