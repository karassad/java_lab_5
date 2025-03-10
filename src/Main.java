import model.*;
//import resources.*;
import java.util.LinkedHashSet;

import parsingXml.XmlParser;

import static sort.SortByAT.sortAT;


public class Main {
    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        String filePath = "C:/Users/kladm/ITMO/IntelliJ IDEA JAVA/java_lab_5/src/resources/test.xml";
        LinkedHashSet<Organization> organizations = null;
        try {
            organizations = (LinkedHashSet<Organization>) parser.parseXml(filePath);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }


        if (organizations != null) {
            // Выводим данные
            System.out.println("original list");
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

        LinkedHashSet<Organization> sortedOrganizations = sortAT(organizations);

        System.out.println("Sorted List (by Annual Turnover):");
        for (Organization org : sortedOrganizations) {
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
