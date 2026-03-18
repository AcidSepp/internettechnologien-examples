package de.haw.landshut.itt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;

import java.io.IOException;
import java.io.InputStream;

public class JsonParsingWithSchema {
    // snippet: JsonParsingWithSchema
    public static void main(String[] args) throws IOException {
        var factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
        var schema = getResourceAsStream("/public/json/lecture-schema.json");
        var jsonSchema = factory.getSchema(schema);

        var mapper = new ObjectMapper();
        var lectureJson = getResourceAsStream("/public/json/lecture.json");
        var jsonNode = mapper.readTree(lectureJson);

        var errors = jsonSchema.validate(jsonNode);
        if (errors.isEmpty()) {
            System.out.println("Success!");
        } else {
            errors.forEach(System.out::println);
        }
    }
// snippet: /JsonParsingWithSchema

    private static InputStream getResourceAsStream(final String name) {
        return JsonParsing.class.getResourceAsStream(name);
    }

}
