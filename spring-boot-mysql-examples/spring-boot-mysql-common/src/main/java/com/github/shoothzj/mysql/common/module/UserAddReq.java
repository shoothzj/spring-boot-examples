package com.github.shoothzj.mysql.common.module;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAddReq {

    private String username;

    private String password;

    public UserAddReq() {
    }
}
