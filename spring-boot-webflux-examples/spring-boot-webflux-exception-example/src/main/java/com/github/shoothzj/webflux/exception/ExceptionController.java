package com.github.shoothzj.webflux.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping(path = "/e1")
    public void exception1() {
        throw new RuntimeException("exception 1");
    }

    @GetMapping(path = "/e2")
    public void exception2() {
        throw new CustomException("exception 2");
    }

}
