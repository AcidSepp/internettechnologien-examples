package de.haw.landshut.itt.rest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// snippet: RequestParametersTest
class RequestParametersTest {
    @Test
    void helloWorld_parametersGiven_correctlyReturned() {
        final var controller = new RequestParameters();
        final var greeting = controller.helloWorld("servus", "weid");
        assertThat(greeting.greeting()).isEqualTo("servus");
        assertThat(greeting.subject()).isEqualTo("weid");
    }
}
// snippet: /RequestParametersTest
