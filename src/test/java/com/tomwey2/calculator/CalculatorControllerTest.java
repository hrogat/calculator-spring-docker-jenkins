package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class CalculatorControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testSum() {
        webTestClient.get().uri("/sum?a=2&b=3")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("5");
    }
}