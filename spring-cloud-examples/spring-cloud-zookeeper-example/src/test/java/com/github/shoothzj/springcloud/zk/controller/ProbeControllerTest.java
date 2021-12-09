package com.github.shoothzj.springcloud.zk.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProbeControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testLivenessProbe() {
        ResponseEntity<Void> entity = template.getForEntity("/liveness", Void.class);
        Assertions.assertEquals(200, entity.getStatusCodeValue());
    }

}