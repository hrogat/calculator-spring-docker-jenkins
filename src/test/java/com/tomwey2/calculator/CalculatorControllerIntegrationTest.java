package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class CalculatorControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSumEndpoint() {
        webTestClient.get()
                .uri("/sum?a=2&b=3")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("5");
    }

    @Test
    void testSumEndpointWithNegativeNumbers() {
        webTestClient.get()
                .uri("/sum?a=-1&b=-1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("-2");
    }

    @Test
    void testSumEndpointWithZero() {
        webTestClient.get()
                .uri("/sum?a=0&b=0")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("0");
    }
}