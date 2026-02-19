package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@WebFluxTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void testSumEndpoint() {
        when(calculatorService.sum(2, 3)).thenReturn(Mono.just(5));
        
        webTestClient.get()
                .uri("/sum?a=2&b=3")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("5");
    }

    @Test
    public void testSumEndpointWithNegativeNumbers() {
        when(calculatorService.sum(-1, -1)).thenReturn(Mono.just(-2));
        
        webTestClient.get()
                .uri("/sum?a=-1&b=-1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("-2");
    }

    @Test
    public void testSumEndpointWithZero() {
        when(calculatorService.sum(0, 0)).thenReturn(Mono.just(0));
        
        webTestClient.get()
                .uri("/sum?a=0&b=0")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("0");
    }

    @Test
    public void testSumEndpointWithLargeNumbers() {
        when(calculatorService.sum(1000000, 2000000)).thenReturn(Mono.just(3000000));
        
        webTestClient.get()
                .uri("/sum?a=1000000&b=2000000")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("3000000");
    }

    @Test
    public void testSumEndpointWithMissingParameter() {
        webTestClient.get()
                .uri("/sum?a=2")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    public void testSumEndpointWithNonNumericParameter() {
        webTestClient.get()
                .uri("/sum?a=abc&b=2")
                .exchange()
                .expectStatus().isBadRequest();
    }
}
