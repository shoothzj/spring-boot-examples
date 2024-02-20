package com.github.shoothzj.reactor.validation;

import com.github.shoothzj.reactor.validation.api.ValidationApiDelegate;
import com.github.shoothzj.reactor.validation.model.ValidationReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class ValidationController implements ValidationApiDelegate {
    @Override
    public Mono<ResponseEntity<Void>> validationPost(Mono<ValidationReq> validationReq, ServerWebExchange exchange) {
        return ValidationApiDelegate.super.validationPost(validationReq, exchange);
    }
}
