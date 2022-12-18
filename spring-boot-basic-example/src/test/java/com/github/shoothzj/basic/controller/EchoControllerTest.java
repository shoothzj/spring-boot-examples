package com.github.shoothzj.basic.controller;

import com.github.shoothzj.basic.TestConfig;
import com.github.shoothzj.basic.module.EchoPostReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EchoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testEcho() throws Exception {
        EchoPostReq echoPostReq = new EchoPostReq();
        echoPostReq.setContent("req");
        ResponseEntity<String> entity = restTemplate.postForEntity("/echo", echoPostReq, String.class);
        Assertions.assertTrue(entity.getStatusCode().is2xxSuccessful());
    }

}
