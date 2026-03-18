import com.fasterxml.jackson.databind.ObjectMapper
import com.networknt.schema.JsonSchemaFactory
import com.networknt.schema.SpecVersion
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class JsonSchemaExamplesTest {

    private val mapper = ObjectMapper()
    private val factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012)

    companion object {
        @JvmStatic
        fun getJsonAndSchemaExamples(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of("/public/json/foobar-required.json", "/public/json/foobar-required-schema.json"),
                    Arguments.of("/public/json/foobar.json", "/public/json/foobar-schema.json"),
                    Arguments.of("/public/json/lecture.json", "/public/json/lecture-schema.json"),
                    Arguments.of("/public/json/nested.json", "/public/json/nested-schema.json"),
                    Arguments.of("/public/json/memo.json", "/public/json/memo-schema.json"),
            )
        }
    }

    @ParameterizedTest
    @MethodSource("getJsonAndSchemaExamples")
    fun testJsonAndSchemaExamples(jsonResource: String, jsonSchemaResource: String) {
        val schema //
                = javaClass.getResourceAsStream(jsonSchemaResource)
        val jsonSchema = factory.getSchema(schema)

        val lectureJson //
                = javaClass.getResourceAsStream(jsonResource)

        val jsonNode = mapper.readTree(lectureJson)
        val errors = jsonSchema.validate(jsonNode)

        assertThat(errors).isEmpty();
    }
}