package com.github.shoothzj.postgre.jpa.lob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories({"com.github.shoothzj.postgre.jpa.lob.repository"})
@EntityScan(basePackages = {"com.github.shoothzj.postgre.jpa.lob.domain"})
public class PostgreExample {
    public static void main(String[] args) {
        SpringApplication.run(PostgreExample.class);
    }
}
