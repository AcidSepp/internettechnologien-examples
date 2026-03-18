package de.haw.landshut.itt.rest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// snippet: HelloWorldRestControllerTest
class HelloWorldRestControllerTest {

    @Test
    void helloWorld_returnsGreeting() {
        final var controller = new HelloWorldRestController();
        final var greeting = controller.helloWorld();
        assertThat(greeting.greeting()).isEqualTo("hello");
        assertThat(greeting.subject()).isEqualTo("world");
    }
}
// snippet: /HelloWorldRestControllerTest
