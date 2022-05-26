package com.github.shoothzj.mongo.config.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github.shoothzj.mongo")
public class MongoConfigCodeExample {

    public static void main(String[] args) {
        SpringApplication.run(MongoConfigCodeExample.class);
    }

}
