package com.example.cloud_game.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Library {

    @Column
    private Long applicationId;

    @Column
    private Long userId;
}
