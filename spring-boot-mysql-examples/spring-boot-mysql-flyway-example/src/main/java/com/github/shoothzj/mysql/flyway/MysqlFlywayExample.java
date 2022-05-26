package com.github.shoothzj.mysql.flyway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github.shoothzj.mysql")
public class MysqlFlywayExample {

    public static void main(String[] args) {
        SpringApplication.run(MysqlFlywayExample.class);
    }

}
