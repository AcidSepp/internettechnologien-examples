package de.haw.landshut.itt;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import java.io.InputStream;

public class XmlParsing {
    // snippet: XmlParsing
    public static void main(String[] args) throws JAXBException {
        var context = JAXBContext.newInstance(XmlLecture.class);
        var unmarshaller = context.createUnmarshaller();

        var resource = getResourceAsStream("/public/xml/lecture.xml");
        var unmarshal = unmarshaller.unmarshal(resource);
        System.out.println(unmarshal);
    }
// snippet: /XmlParsing

    private static InputStream getResourceAsStream(final String name) {
        return XmlParsing.class.getResourceAsStream(name);
    }
}

