package com.github.shoothzj.h2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_REG_ID_SEQ")
    @SequenceGenerator(name = "T_REG_ID_SEQ", sequenceName = "T_REG_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(length = 256)
    private String username;

    @Column(length = 64)
    private String password;

    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
