package FileManage;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.util.LinkedHashSet;

import model.*;

public class XmlParser {
    public LinkedHashSet<Organization> parseXml(String filePath) {

        //filereader можем не использовать, т.к. JAXB может напрямую работать с файлами
        try(FileReader reader = new FileReader(filePath)) {
            StringBuilder content = new StringBuilder(); //создаем буффер для хранения содержимого файла
            int ch;
            while ((ch = reader.read()) != -1){ //читает каждый символ, возвращает в виде Unicode
                content.append((char) ch); //char переводит zunicod в символ
            }
            String xmlContent = content.toString(); //вовращает содержимое буффера в виде строки

//            JAXBContext context = JAXBContext.newInstance(Organizations.class);
            JAXBContext context = JAXBContext.newInstance(
                    Organizations.class,
                    Organization.class,
                    Coordinates.class,
                    Address.class,
                    OrganizationType.class
            );

            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(filePath);
            Organizations organizations = (Organizations) unmarshaller.unmarshal(new StringReader(xmlContent));

            // Блок валидации данных
            boolean hasErrors = false;
            for (Organization org : organizations.getOrganizations()) {
                try {
                    org.validate();
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка валидации организации ID " + org.getId() + " " + org.getName() + ": " + e.getMessage());
                    hasErrors = true;
                }
            }
            if (hasErrors) {
                return null; // Прерываем вывод при наличии ошибок
            }
            return organizations.getOrganizations();
        } catch (JAXBException | FileNotFoundException e) {
            System.err.println("Ошибка парсинга XML: " + e.getMessage());
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
