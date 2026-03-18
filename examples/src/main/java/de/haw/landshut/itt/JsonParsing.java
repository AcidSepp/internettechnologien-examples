package de.haw.landshut.itt;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonParsing {
    public static void main(String[] args) throws IOException {
        var mapper = new ObjectMapper();

        try (var resource = JsonParsing.class.getResourceAsStream("/public/json/lecture.json")) {
            final var lecture = mapper.readValue(resource, JsonLecture.class);
            System.out.println(lecture);
        }
    }
}
