package com.github.shoothzj.reactor.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    @GetMapping(value = "/hello-1m")
    public Mono<String> get() {
        Scheduler singleThread = Schedulers.single();
        return Mono.just("").publishOn(singleThread).map(s -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "xxx";
        }).onErrorReturn("error");
    }

}
