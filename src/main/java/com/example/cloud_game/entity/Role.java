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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(Set<UserInfo> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", users=" + users +
                '}';
    }
}

