package com.github.shoothzj.mysql.common.controller;

import com.github.shoothzj.mysql.common.domain.User;
import com.github.shoothzj.mysql.common.module.UserAddReq;
import com.github.shoothzj.mysql.common.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userRepository.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<String> addUser(@RequestBody UserAddReq userAddReq) {
        User user = new User();
        user.setUsername(userAddReq.getUsername());
        user.setPassword(userAddReq.getPassword());
        User save = userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
