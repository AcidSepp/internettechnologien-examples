import com.fasterxml.jackson.databind.ObjectMapper
import com.networknt.schema.JsonSchemaFactory
import com.networknt.schema.SpecVersion
import com.networknt.schema.ValidationMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class JsonSchemaExercisesTest {

    private val mapper = ObjectMapper()
    private val factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012)

    @Test
    fun exercise1_invalid() {
        val schemaResourcePath = "/public/json/schema-exercise/exercise1-schema.json"
        val jsonResourcePath = "public/json/schema-exercise/exercise1.json"

        val errors = validationMessages(schemaResourcePath, jsonResourcePath)

        assertThat(errors.first()).satisfies({
            assertThat(it.message).contains("number found, string expected")
        })
    }

    @Test
    fun exercise2_valid() {
        val schemaResourcePath = "/public/json/schema-exercise/exercise2-schema.json"
        val jsonResourcePath = "public/json/schema-exercise/exercise2.json"

        val errors = validationMessages(schemaResourcePath, jsonResourcePath)

        assertThat(errors).isEmpty()
    }

    @Test
    fun exercise3_invalid() {
        val schemaResourcePath = "/public/json/schema-exercise/exercise3-schema.json"
        val jsonResourcePath = "public/json/schema-exercise/exercise3.json"

        val errors = validationMessages(schemaResourcePath, jsonResourcePath)

        assertThat(errors.first()).satisfies({
            assertThat(it.message).contains("property 'bar' is not defined in the schema and the schema does not allow additional properties")
        })
    }

    @Test
    fun exercise4_invalid() {
        val schemaResourcePath = "/public/json/schema-exercise/exercise4-schema.json"
        val jsonResourcePath = "public/json/schema-exercise/exercise4.json"

        val errors = validationMessages(schemaResourcePath, jsonResourcePath)

        assertThat(errors.first()).satisfies({
            assertThat(it.message).contains("required property 'foo' not found")
        })
    }


    private fun validationMessages(schemaResourcePath: String, jsonResourcePath: String): Set<ValidationMessage> {
        val schema = javaClass.getResourceAsStream(schemaResourcePath)
        val jsonSchema = factory.getSchema(schema)
        val lectureJson = javaClass.getResourceAsStream(jsonResourcePath)
        val jsonNode = mapper.readTree(lectureJson)
        val errors = jsonSchema.validate(jsonNode)
        return errors
    }
}