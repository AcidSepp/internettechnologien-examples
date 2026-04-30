import de.haw.landshut.itt.XmlLecture;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

// snippet: XmlParsing
void main() throws JAXBException {
    var context = JAXBContext.newInstance(XmlLecture.class);
    var unmarshaller = context.createUnmarshaller();

    var resource = getClass().getResourceAsStream("/public/xml/lecture.xml");
    var unmarshal = unmarshaller.unmarshal(resource);
    IO.println(unmarshal);
}
// snippet: /XmlParsing


