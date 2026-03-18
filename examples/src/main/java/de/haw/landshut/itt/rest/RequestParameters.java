package de.haw.landshut.itt.rest;

import de.haw.landshut.itt.rest.pojo.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// snippet: requestParameters
@RestController
public class RequestParameters {

    @GetMapping(value = "/v2/greeting")
    @ResponseBody
    public Greeting helloWorld(
            @RequestParam(defaultValue = "world") String greeting,
            @RequestParam(defaultValue = "hello") String subject) {
        return new Greeting(greeting, subject);
    }
}
// snippet: /requestParameters
