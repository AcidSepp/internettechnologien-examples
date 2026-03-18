package de.haw.landshut.itt.rest;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnCodes {

// snippet: example1
    @GetMapping(value = "/return/codes/example/1")
    @ResponseBody
    public ResponseEntity<?> example1() {
        return ResponseEntity.status(404).build();
    }
// snippet: /example1

// snippet: example2
    @GetMapping(value = "/return/codes/example/2")
    @ResponseBody
    public ResponseEntity<?> example2() {
        return ResponseEntity.noContent().build();
    }
// snippet: /example2


// snippet: example3
    @GetMapping(value = "/return/codes/example/3")
    @ResponseBody
    public ResponseEntity<?> example3() {
        throw new RuntimeException();
    }
// snippet: /example3

// snippet: example4
    @GetMapping(value = "/return/codes/example/4")
    @ResponseBody
    public ResponseEntity<?> example4() {
        throw new ErrorResponseException(HttpStatusCode.valueOf(403));
    }
// snippet: /example4

// snippet: example5
    @GetMapping(value = "/return/codes/example/5")
    @ResponseBody
    public ResponseEntity<?> example5() {
        final var body = ProblemDetail.forStatus(404);
        body.setDetail("I just do not like this request!");
        return ResponseEntity.of(body).build();
    }
// snippet: /example5
}
