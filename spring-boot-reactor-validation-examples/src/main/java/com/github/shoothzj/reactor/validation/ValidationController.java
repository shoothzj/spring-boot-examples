package com.github.shoothzj.reactor.validation;

import com.github.shoothzj.reactor.validation.api.ValidationApiDelegate;
import com.github.shoothzj.reactor.validation.model.ValidationParentNullableChildRequiredPostRequest;
import com.github.shoothzj.reactor.validation.model.ValidationReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class ValidationController implements ValidationApiDelegate {
    @Override
    public Mono<ResponseEntity<Void>> validationPost(Mono<ValidationReq> validationReq, ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok().build());
    }

    @Override
    public Mono<ResponseEntity<Void>> validationParentNullableChildRequiredPost(Mono<ValidationParentNullableChildRequiredPostRequest> validationParentNullableChildRequiredPostRequest, ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok().build());
    }

    @Override
    public Mono<ResponseEntity<Void>> validationPathStringPathGet(String path, ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok().build());
    }
}
