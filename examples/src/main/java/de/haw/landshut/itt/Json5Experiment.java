import com.fasterxml.jackson.databind.ObjectMapper;
import de.haw.landshut.itt.Memo;

import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER;
import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_JAVA_COMMENTS;
import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS;
import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS;
import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS;
import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_SINGLE_QUOTES;
import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_COMMA;
import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS;
import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;


void main() throws IOException {
// snippet: Json5Experiment
    var mapper = new ObjectMapper();

    var objectReader = mapper.readerFor(Memo.class)
            .with(ALLOW_UNQUOTED_FIELD_NAMES)
            .with(ALLOW_TRAILING_COMMA)
            .with(ALLOW_SINGLE_QUOTES)
            .with(ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)
            .with(ALLOW_NON_NUMERIC_NUMBERS)
            .with(ALLOW_JAVA_COMMENTS)
            .with(ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS)
            .with(ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS)
            .with(ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS);
// snippet: /Json5Experiment

    try (var resource = getClass().getResourceAsStream("/public/json/memo.json5")) {
        final var lecture = objectReader.readValue(resource);
        IO.println(lecture);
    }
}
