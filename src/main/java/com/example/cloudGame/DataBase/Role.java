package com.example.cloudGame.DataBase;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<UserInfo> userInfo;

}

