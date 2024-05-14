package com.github.shoothzj.reactor.mysql.common.controller;

import com.github.shoothzj.reactor.mysql.common.domain.User;
import com.github.shoothzj.reactor.mysql.common.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepo userRepo;

    @GetMapping(path = "/user/test")
    public Mono<ResponseEntity<Void>> getUsers() {
        log.info("begin to save user");
        User user = new User();
        user.setUsername("test_user");
        user.setPassword("secure_password");

        return userRepo.save(user)
                .doOnSuccess(savedUser -> log.info("Successfully saved user: {}", savedUser)) // Log successful save
                .doOnError(error -> log.error("Error occurred while saving user", error)) // Log any errors that occur
                .then(Mono.just(ResponseEntity.ok().build()));
    }
}
