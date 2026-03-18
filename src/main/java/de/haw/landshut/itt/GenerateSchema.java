package de.haw.landshut.itt;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.SchemaOutputResolver;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class GenerateSchema {
    // snippet: GenerateSchema
    public static void main(String[] args) throws Exception {
        var context = JAXBContext.newInstance(XmlLecture.class);
        context.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(final String namespaceUri, final String suggestedFileName) {
                final var file = new File("build/schema/" + suggestedFileName);
                file.getParentFile().mkdirs();
                return new StreamResult(file);
            }
        });
    }
// snippet: /GenerateSchema
}
