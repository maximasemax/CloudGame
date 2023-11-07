package com.example.cloudGame.DataBase;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "USERINFO")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String login;

    @Column
    private String email;

    @Column
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ROLE_ID", unique = true, nullable = false)
    private Role role;
}
