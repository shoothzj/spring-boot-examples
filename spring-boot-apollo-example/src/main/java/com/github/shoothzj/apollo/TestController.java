package com.github.shoothzj.apollo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${spring.profiles.active}")
    private String profile;

    @Value("${key1}")
    private String value1;

    @GetMapping(path = "/key")
    public ResponseEntity<Void> getCountries() {
        System.out.println("Profile: " + profile);
        System.out.println("Value of key1: " + value1);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
