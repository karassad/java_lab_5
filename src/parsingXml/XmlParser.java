package parsingXml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

import model.Organizations;
import model.Organization;

public class XmlParser {
    public List<Organization> parseXml(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Organizations.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(filePath);
            Organizations organizations = (Organizations) unmarshaller.unmarshal(file);

            return organizations.getOrganizations();
        } catch (JAXBException e) {
            System.err.println("Ошибка парсинга XML: " + e.getMessage());
            return null;
        }
    }
}
