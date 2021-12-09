package com.github.shoothzj.springcloud.zk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProbeController {

    @GetMapping(path = "/liveness")
    public void liveness() {

    }

}
