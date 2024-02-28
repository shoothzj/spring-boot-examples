package com.github.shoothzj.reactor.file;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FileController {
    @PostMapping(value = "/file", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Mono<ResponseEntity<Void>> createPerson(@RequestPart(value = "config") FileConfig config) {
        return Mono.just(new ResponseEntity<>(HttpStatus.OK));
    }
}
