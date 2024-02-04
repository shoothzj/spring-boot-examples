package com.github.shoothzj.reactor.h2.controller;

import com.github.shoothzj.reactor.h2.module.CreatePersonReq;
import com.github.shoothzj.reactor.h2.module.PersonResp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest {
    @Autowired
    private PersonController personController;

    @Test
    public void testPerson() {
        CreatePersonReq createPersonReq = new CreatePersonReq();
        createPersonReq.setName("hzj");
        ResponseEntity<PersonResp> responseEntity = personController.createPerson(Mono.just(createPersonReq)).block();
    }
}
