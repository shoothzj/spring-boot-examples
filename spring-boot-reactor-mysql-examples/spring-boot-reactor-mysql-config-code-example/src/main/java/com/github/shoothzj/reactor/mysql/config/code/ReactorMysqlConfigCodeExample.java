package com.github.shoothzj.reactor.mysql.config.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories("com.github.shoothzj.reactor.mysql.common.repo")
@SpringBootApplication(scanBasePackages = "com.github.shoothzj.reactor.mysql")
public class ReactorMysqlConfigCodeExample {
    public static void main(String[] args) {
        SpringApplication.run(ReactorMysqlConfigCodeExample.class);
    }
}
