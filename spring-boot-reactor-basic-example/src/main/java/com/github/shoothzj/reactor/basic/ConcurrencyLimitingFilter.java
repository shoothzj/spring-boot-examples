package com.github.shoothzj.reactor.basic;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.concurrent.Semaphore;

@Component
public class ConcurrencyLimitingFilter implements WebFilter {
    private final Semaphore semaphore;

    public ConcurrencyLimitingFilter() {
        this.semaphore = new Semaphore(10);
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        if (semaphore.tryAcquire()) {
            return chain.filter(exchange)
                    .doFinally(sig -> semaphore.release());
        } else {
            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
            return exchange.getResponse().setComplete();
        }
    }
}
