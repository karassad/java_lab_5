import model.*;
//import resources.*;
import java.util.List;

import parsingXml.XmlParser;


public class Main {
    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        String filePath = "C:/Users/kladm/ITMO/IntelliJ IDEA JAVA/java_lab_5/src/resources/test.xml";
        List<Organization> organizations = parser.parseXml(filePath);

        if (organizations != null) {
            // Выводим данные
            for (Organization org : organizations) {
                System.out.println("ID: " + org.getId());
                System.out.println("Name: " + org.getName());
                System.out.println("Coordinates: (" + org.getCoordinates().getX() +
                        ", " + org.getCoordinates().getY() + ")");
                System.out.println("Creation Date: " + org.getCreationDate());
                System.out.println("Annual Turnover: " + org.getAnnualTurnover());
                System.out.println("Type: " + org.getType());
                System.out.println("Zip Code: " + org.getOfficialAddress().getZipCode());
                System.out.println();
            }
        }
    }

}
