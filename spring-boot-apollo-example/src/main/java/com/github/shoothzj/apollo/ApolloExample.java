package com.github.shoothzj.apollo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.github.shoothzj.apollo")
public class ApolloExample {

    public static void main(String[] args) {
        SpringApplication.run(ApolloExample.class);
    }

}
