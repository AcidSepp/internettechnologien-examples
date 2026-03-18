package de.haw.landshut.itt.rest;


import de.haw.landshut.itt.rest.pojo.Greeting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PathVariablesIT {

    @LocalServerPort
    private int port;

    private WebTestClient webTestClient;

    @BeforeEach
    void setup() {
        webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
    }

    // snippet: testHelloWorldEndpoint
    @Test
    @Timeout(value = 5, unit = TimeUnit.MINUTES)
    void testHelloWorldEndpoint() {
        webTestClient.get()
                .uri("/v3/greeting/servus/weid")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Greeting.class)
                .value(greeting -> {
                    assertThat(greeting.greeting()).isEqualTo("servus");
                    assertThat(greeting.subject()).isEqualTo("weid");
                });
    }
// snippet: /testHelloWorldEndpoint

}
