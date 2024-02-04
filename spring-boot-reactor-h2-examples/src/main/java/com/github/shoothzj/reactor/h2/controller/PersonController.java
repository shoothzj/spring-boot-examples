package com.github.shoothzj.reactor.h2.controller;

import com.github.shoothzj.reactor.h2.domain.PersonPo;
import com.github.shoothzj.reactor.h2.module.CreatePersonReq;
import com.github.shoothzj.reactor.h2.module.PersonResp;
import com.github.shoothzj.reactor.h2.repo.PersonRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping(value = "/persons", produces = "application/json", consumes = "application/json")
    Mono<ResponseEntity<PersonResp>> createPerson(@RequestBody @Valid Mono<CreatePersonReq> createPersonReq) {
        return createPersonReq
                .flatMap(req -> {
                    PersonPo personPo = new PersonPo();
                    personPo.setAge(18);
                    personPo.setName(req.getName());
                    return personRepo.save(personPo);
                })
                .map(person -> {
                    PersonResp personResp = new PersonResp();
                    personResp.setName(person.getName());
                    return new ResponseEntity<>(personResp, null, HttpStatus.CREATED);
                });
    }

    @GetMapping(value = "/persons/{id}", produces = "application/json", consumes = "application/json")
    Mono<ResponseEntity<PersonResp>> getPerson(@PathVariable("id") Long id) {
        return personRepo.findById(id)
                .map(person -> {
                    PersonResp personResp = new PersonResp();
                    personResp.setName(person.getName());
                    return new ResponseEntity<>(personResp, null, HttpStatus.OK);
                });
    }
}
