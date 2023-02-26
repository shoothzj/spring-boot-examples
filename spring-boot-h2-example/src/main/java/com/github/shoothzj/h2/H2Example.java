package com.github.shoothzj.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories({"com.github.shoothzj.h2.repository"})
@EntityScan(basePackages = {"com.github.shoothzj.h2.domain"})
@SpringBootApplication
public class H2Example {
    public static void main(String[] args) {
        SpringApplication.run(H2Example.class);
    }
}
