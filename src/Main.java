import model.*;
import parsingXml.XmlFileLoader;
import parsingXml.XmlReader;
//import resources.*;
import java.util.Set;
import java.util.LinkedHashSet;



public class Main {
    public static void main(String[] args) throws Exception {

        //считали в строку xml
        String filepath = "C:/Users/kladm/ITMO/IntelliJ IDEA JAVA/java_lab_5/src/resources/test.xml";
        String filename = filepath;
        String xmlContent = XmlFileLoader.loadXmlFile(filename);

        //создаем сет из объектов
        if (xmlContent != null) {
            Set<Organization> organizations = XmlReader.parseXml(xmlContent);
            for (Organization org : organizations) {
                System.out.println("ID: " + org.getId());
                System.out.println("Name: " + org.getName());
                System.out.println("Coordinates: " + org.getCoordinates());
                System.out.println("CreationDate: " + org.getCreationDate());
                System.out.println("Turnover: " + org.getAnnualTurnover());
                System.out.println("Type: " + org.getType());
                System.out.println("Address: " + org.getOfficialAddress());
                System.out.println();
            }
        } else {
            System.err.println("Failed to load XML file");
        }
    }
}
