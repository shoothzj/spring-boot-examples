package com.github.shoothzj.reactor.h2.controller;

import com.github.shoothzj.reactor.h2.domain.PersonPo;
import com.github.shoothzj.reactor.h2.module.CreatePersonReq;
import com.github.shoothzj.reactor.h2.module.CreatePersonResp;
import com.github.shoothzj.reactor.h2.repo.PersonRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {
    @Autowired
    private final PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @PostMapping(value = "/person", produces = "application/json", consumes = "application/json")
    Mono<ResponseEntity<CreatePersonResp>> createPerson(@RequestBody @Valid Mono<CreatePersonReq> createPersonReq) {
        return createPersonReq
                .flatMap(req -> {
                    PersonPo personPo = new PersonPo();
                    personPo.setAge(18);
                    personPo.setName(req.getName());
                    return personRepo.save(personPo);
                })
                .map(person -> {
                    CreatePersonResp createPersonResp = new CreatePersonResp();
                    createPersonResp.setName(person.getName());
                    return new ResponseEntity<>(createPersonResp, null, HttpStatus.CREATED);
                });
    }
}
