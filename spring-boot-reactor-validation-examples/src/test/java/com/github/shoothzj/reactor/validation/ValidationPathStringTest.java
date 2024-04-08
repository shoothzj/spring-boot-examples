package com.github.shoothzj.reactor.validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

public class ValidationPathStringTest extends BaseTestController {
    @Test
    public void testPathStringValid() {
        webTestClient.get().uri("/validation-path-string/4444")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testPathStringLong() {
        webTestClient.get().uri("/validation-path-string/55555")
                .exchange()
                .expectStatus().is5xxServerError();
    }
}
