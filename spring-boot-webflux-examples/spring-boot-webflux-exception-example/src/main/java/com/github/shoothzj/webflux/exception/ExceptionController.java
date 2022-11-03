package com.github.shoothzj.webflux.exception;

import org.springframework.web.bind.annotation.GetMapping;

public class ExceptionController {

    @GetMapping
    public void exception1() {
        throw new RuntimeException("exception 1");
    }

    @GetMapping
    public void exception2() {
        throw new CustomException("exception 2");
    }

}
