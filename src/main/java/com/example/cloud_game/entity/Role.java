package com.example.cloud_game.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<UserInfo> users;

}

