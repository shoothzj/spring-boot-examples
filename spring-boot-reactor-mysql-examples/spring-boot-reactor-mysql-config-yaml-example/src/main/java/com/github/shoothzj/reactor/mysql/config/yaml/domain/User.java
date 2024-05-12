package com.github.shoothzj.reactor.mysql.config.yaml.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * DROP TABLE IF EXISTS T_User;
 * CREATE TABLE T_User (
 *     id BIGINT PRIMARY KEY AUTO_INCREMENT,
 *     username VARCHAR(255) NOT NULL,
 *     password VARCHAR(255) NOT NULL,
 *     created_time DATETIME(3) DEFAULT,
 *     updated_time DATETIME(3) DEFAULT,
 * );
 */
@Table(name = "T_User")
@ToString(callSuper = true)
@Setter
@Getter
public class User extends AuditableEntity {

    @Id
    @Column("id")
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
