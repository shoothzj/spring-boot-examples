package com.github.shoothzj.basic.controller;

import com.github.shoothzj.basic.module.EchoPostReq;
import com.github.shoothzj.basic.module.EchoPostResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    @PostMapping(path = "/echo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EchoPostResp> echo(@RequestBody EchoPostReq echoPostReq) {
        EchoPostResp resp = new EchoPostResp();
        resp.setContent(echoPostReq.getContent());
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}
