package com.github.shoothzj.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@EnableApolloConfig
@SpringBootApplication(scanBasePackages = "com.github.shoothzj.apollo")
public class ApolloExample {

    public static void main(String[] args) {
        SpringApplication.run(ApolloExample.class);
    }

}
