import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.File

class JsonExamplesTest {

    private val mapper = ObjectMapper()

    @Test
    fun testJsonExamples() {
        val file = File(javaClass.getResource("/public/json/")!!.toURI())
        file.walk().filter {
            it.isFile
        }.filter { it.toString().endsWith("json") }.filterNot { it.toString().contains("broken") }.forEach {
            mapper.readTree(it)
        }
    }

    @Test
    fun testBrokenJsonExamples() {
        val file = File(javaClass.getResource("/public/json/")!!.toURI())
        file.walk().filter {
            it.isFile
        }.filter { it.toString().endsWith("json") }.filter { it.toString().contains("broken") }.forEach {
            assertThrows<Exception>("$it should be invalid but was valid.") { mapper.readTree(it) }
        }
    }
}