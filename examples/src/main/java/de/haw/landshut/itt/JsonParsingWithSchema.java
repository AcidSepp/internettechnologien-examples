import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;

import java.io.IOException;

// snippet: JsonParsingWithSchema

void main() throws IOException {
    var factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
    var schema = getClass().getResourceAsStream("/public/json/lecture-schema.json");
    var jsonSchema = factory.getSchema(schema);

    var mapper = new ObjectMapper();
    var lectureJson = getClass().getResourceAsStream("/public/json/lecture-with-schema.json");
    var jsonNode = mapper.readTree(lectureJson);

    var errors = jsonSchema.validate(jsonNode);
    if (errors.isEmpty()) {
        IO.println("Success!");
    } else {
        errors.forEach(IO::println);
    }
}
// snippet: /JsonParsingWithSchema


