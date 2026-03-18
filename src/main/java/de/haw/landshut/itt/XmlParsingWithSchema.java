package de.haw.landshut.itt;

import jakarta.xml.bind.JAXBContext;
import org.jetbrains.annotations.Nullable;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.InputStream;

public class XmlParsingWithSchema {
// snippet: XmlParsingWithSchema
    public static void main(String[] args) throws Exception {

        var sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        var xsdStream = getResourceAsStream("/public/xml/lecture.xsd");
        var schema = sf.newSchema(new StreamSource(xsdStream));

        var context = JAXBContext.newInstance(XmlLecture.class);
        var unmarshaller = context.createUnmarshaller();
        unmarshaller.setSchema(schema);

        var xmlStream = getResourceAsStream("/public/xml/lecture.xml");
        var unmarshal = unmarshaller.unmarshal(xmlStream);
        System.out.println(unmarshal);
    }
// snippet: /XmlParsingWithSchema

    private static InputStream getResourceAsStream(final String name) {
        return XmlParsingWithSchema.class.getResourceAsStream(name);
    }
}

