import de.haw.landshut.itt.XmlLecture;
import jakarta.xml.bind.JAXBContext;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

// snippet: XmlParsingWithSchema

void main() throws Exception {
    var sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    var xsdStream = getClass().getResourceAsStream("/public/xml/lecture.xsd");
    var schema = sf.newSchema(new StreamSource(xsdStream));

    var context = JAXBContext.newInstance(XmlLecture.class);
    var unmarshaller = context.createUnmarshaller();
    unmarshaller.setSchema(schema);

    var xmlStream = getClass().getResourceAsStream("/public/xml/lecture.xml");
    var unmarshal = unmarshaller.unmarshal(xmlStream);
    IO.println(unmarshal);
}
// snippet: /XmlParsingWithSchema


