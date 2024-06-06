package com.github.shoothzj.reactor.basic;

import com.github.shoothzj.reactor.basic.exception.CustomException;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class RequestTimeoutFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return chain.filter(exchange)
                .timeout(Duration.ofSeconds(5))
                .onErrorResume(e -> handleTimeout(exchange, e));
    }

    private Mono<Void> handleTimeout(ServerWebExchange exchange, Throwable e) {
        if (e instanceof java.util.concurrent.TimeoutException) {
            return Mono.error(new CustomException("xxxx"));
        }
        return Mono.error(e);
    }
}
