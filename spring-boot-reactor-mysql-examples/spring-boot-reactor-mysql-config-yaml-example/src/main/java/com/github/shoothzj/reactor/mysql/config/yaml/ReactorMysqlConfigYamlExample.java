package com.github.shoothzj.reactor.mysql.config.yaml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@EnableR2dbcAuditing
@SpringBootApplication
public class ReactorMysqlConfigYamlExample {
    public static void main(String[] args) {
        SpringApplication.run(ReactorMysqlConfigYamlExample.class, args);
    }
}
