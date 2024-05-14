package com.github.shoothzj.reactor.mysql.config.yaml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcAuditing
@EnableR2dbcRepositories("com.github.shoothzj.reactor.mysql.common.repo")
@SpringBootApplication(scanBasePackages = "com.github.shoothzj.reactor.mysql")
public class ReactorMysqlConfigYamlExample {
    public static void main(String[] args) {
        SpringApplication.run(ReactorMysqlConfigYamlExample.class, args);
    }
}
