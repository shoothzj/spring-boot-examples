package com.github.shoothzj.webflux.reactor.netty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public Flux<String> get() {
        return Flux.just("hello");
    }

}
