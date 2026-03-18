package de.haw.landshut.itt.rest;

import de.haw.landshut.itt.rest.pojo.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// snippet: pathVariables
@RestController
public class PathVariables {

    @GetMapping(value = "/v3/greeting/{greeting}/{subject}")
    @ResponseBody
    public Greeting helloWorld(@PathVariable String greeting, @PathVariable String subject) {
        return new Greeting(greeting, subject);
    }
}
// snippet: /pathVariables
