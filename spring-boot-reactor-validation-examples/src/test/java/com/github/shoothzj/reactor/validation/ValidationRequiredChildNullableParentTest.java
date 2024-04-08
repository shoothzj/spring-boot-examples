package com.github.shoothzj.reactor.validation;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

public class ValidationRequiredChildNullableParentTest extends BaseTestController{
    @Test
    public void testParentNull() {
        webTestClient.post().uri("/validation-parent-nullable-child-required")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{}")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testParentExistChildrenNull() {
        String requestBody = "{ \"parent\": {} }";
        webTestClient.post().uri("/validation-parent-nullable-child-required")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testParentExistChildrenExist() {
        String requestBody = "{ \"parent\": { \"child\": { \"validationString\": \"abc\" } } }";
        webTestClient.post().uri("/validation-parent-nullable-child-required")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .exchange()
                .expectStatus().isOk();
    }
}
