package com.github.shoothzj.webflux.reactor.netty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.github.shoothzj.webflux.reactor.netty")
public class WebfluxReactorNettyExample {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxReactorNettyExample.class);
    }

}
