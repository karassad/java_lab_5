import model.*;
//import resources.*;
import java.util.LinkedHashSet;

import FileManage.XmlParser;
import сomandContainer.AddCommand;
import сomandContainer.SaveCommand;
import сomandContainer.UpdateCommand;

import static sort.SortByAT.sortAT;


public class Main {
    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        String filePath = "C:/Users/kladm/ITMO/IntelliJ IDEA JAVA/java_lab_5/src/resources/test.xml";
        LinkedHashSet<Organization> organizations = null;
        try {
            organizations = (LinkedHashSet<Organization>) parser.parseXml(filePath);
            for (Organization org : organizations) {
                org.updateIdAndCreationDate();
            }
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

        AddCommand addCommand = new AddCommand();

        // Выполняем команду добавления элемента
//        System.out.println("Ввод данных для новой организации:");
//        addCommand.execute(organizations, new String[0]);

        UpdateCommand updateCommand = new UpdateCommand();
//        updateCommand.execute(organizations, new String[0]);

        SaveCommand saveCommand = new SaveCommand();
        saveCommand.execute(organizations, new String[]{});

    }



}
