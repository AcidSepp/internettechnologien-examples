package de.haw.landshut.itt.rest;

import de.haw.landshut.itt.rest.pojo.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// snippet: helloWorld
@RestController
public class HelloWorldRestController {

    @GetMapping(value = "/v1/greeting")
    @ResponseBody
    public Greeting helloWorld() {
        return new Greeting("hello", "world");
    }
}
// snippet: /helloWorld
