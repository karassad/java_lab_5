package сomandContainer;

import interfaces.Command;
import model.Organization;

import java.util.LinkedHashSet;
import java.util.Scanner;

import static sort.SortByAT.sortAT;

public class RemoveCommand implements Command {
    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод ID организации для удаления
        System.out.print("Введите ID организации для удаления: ");
        int id = scanner.nextInt();
//        scanner.nextLine();  // consume the leftover newline

        // Поиск организации по ID
        Organization organizationToRemove = null;
        for (Organization org : organizations) {
            if (org.getId() == id) {
                organizationToRemove = org;
                break;
            }
        }

        if (organizationToRemove == null) {
            System.out.println("Организация с таким ID не найдена.");
            return;
        }

        // Удаление организации из коллекции
        organizations.remove(organizationToRemove);
        System.out.println("Организация с ID " + id + " удалена.");


        // Выводим коллекцию после удаления
        System.out.println("\nСодержимое коллекции после удаления:");
        for (Organization org : organizations) {
            System.out.println("ID: " + org.getId());
            System.out.println("Name: " + org.getName());
            System.out.println("Coordinates: (" + org.getCoordinates().getX() + ", " + org.getCoordinates().getY() + ")");
            System.out.println("Annual Turnover: " + org.getAnnualTurnover());
            System.out.println("Type: " + org.getType());
            System.out.println("ZIP Code: " + org.getOfficialAddress().getZipCode());
            System.out.println();
        }
    }
}
