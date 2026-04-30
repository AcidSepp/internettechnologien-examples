import com.fasterxml.jackson.databind.ObjectMapper;
import de.haw.landshut.itt.JsonLecture;

import java.io.IOException;

void main() throws IOException {
    var mapper = new ObjectMapper();

    try (var resource = getClass().getResourceAsStream("/public/json/lecture.json")) {
        final var lecture = mapper.readValue(resource, JsonLecture.class);
        IO.println(lecture);
    }
}
