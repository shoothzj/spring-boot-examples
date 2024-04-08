package com.github.shoothzj.reactor.validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

public class ValidationControllerTest extends BaseTestController {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testValidationFailureEmptyValidationMap() {
        String requestBody = "{\"validationMap\":{}}";

        webTestClient.post().uri("/validation")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testValidationFailureTooManyProperties() {
        String requestBody = "{\"validationMap\":{" +
                "\"key1\":\"value1\"," +
                "\"key2\":\"value2\"," +
                "\"key3\":\"value3\"," +
                "\"key4\":\"value4\"," +
                "\"key5\":\"value5\"," +
                "\"key6\":\"value6\"" +
                "}}";
        webTestClient.post().uri("/validation")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testValidationIntegerMax() {
        String requestBody = """
                {"validationInteger":1025}
                """;
        webTestClient.post().uri("/validation")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .exchange()
                .expectStatus().isOk();
    }
}
