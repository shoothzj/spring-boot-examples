package com.github.shoothzj.webflux.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github.shoothzj.webflux.exception")
public class WebfluxExceptionExample {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxExceptionExample.class);
    }

}
