package com.github.shoothzj.reactor.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcAuditing
@EnableR2dbcRepositories("com.github.shoothzj.reactor.h2.repo")
public class ReactorH2Example {
    public static void main(String[] args) {
        SpringApplication.run(ReactorH2Example.class, args);
    }
}
