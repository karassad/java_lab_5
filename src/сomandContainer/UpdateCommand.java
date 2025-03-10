package сomandContainer;

import interfaces.Command;
import model.Organization;
import model.Coordinates;
import model.Address;
import model.OrganizationType;
import java.util.LinkedHashSet;
import java.util.Scanner;

import static sort.SortByAT.sortAT;

/**
 * Команда для обновления элемента в коллекции по id.
 */
public class UpdateCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод ID организации для обновления
        System.out.print("Введите ID организации для обновления: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // consume the leftover newline

        // Поиск организации по ID
        Organization organizationToUpdate = null;
        for (Organization org : organizations) {
            if (org.getId() == id) {
                organizationToUpdate = org;
                break;
            }
        }

        if (organizationToUpdate == null) {
            System.out.println("Организация с таким ID не найдена.");
            return;
        }

        System.out.println("Организация найдена: " + organizationToUpdate.getName());

        // Ввод нового имени организации
        System.out.print("Введите новое имя организации (или нажмите Enter для сохранения старого): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            organizationToUpdate.setName(newName);
        }

        // Ввод новых координат
        System.out.print("Введите новые координаты (X) (или нажмите Enter для сохранения старых): ");
        String newXStr = scanner.nextLine();
        if (!newXStr.isEmpty()) {
            double newX = Double.parseDouble(newXStr);
            organizationToUpdate.getCoordinates().setX(newX);
        }

        System.out.print("Введите новые координаты (Y) (или нажмите Enter для сохранения старых): ");
        String newYStr = scanner.nextLine();
        if (!newYStr.isEmpty()) {
            int newY = Integer.parseInt(newYStr);
            organizationToUpdate.getCoordinates().setY(newY);
        }

        // Ввод нового годового оборота
        System.out.print("Введите новый годовой оборот (или нажмите Enter для сохранения старого): ");
        String newAnnualTurnoverStr = scanner.nextLine();
        if (!newAnnualTurnoverStr.isEmpty()) {
            double newAnnualTurnover = Double.parseDouble(newAnnualTurnoverStr);
            organizationToUpdate.setAnnualTurnover(newAnnualTurnover);
        }

        // Ввод нового типа организации
        System.out.println("Выберите новый тип организации (или нажмите Enter для сохранения старого): ");
        for (OrganizationType type : OrganizationType.values()) {
            System.out.println(type);
        }

        String newTypeStr = scanner.nextLine();
        if (!newTypeStr.isEmpty()) {
            try {
                OrganizationType newType = OrganizationType.valueOf(newTypeStr.toUpperCase());
                organizationToUpdate.setType(newType);
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод типа организации. Тип не изменен.");
            }
        }

        // Ввод нового ZIP кода
        System.out.print("Введите новый ZIP код (или нажмите Enter для сохранения старого): ");
        String newZipCode = scanner.nextLine();
        if (newZipCode.length() > 28){
            System.out.println("ZIP код не должен быть содержать более 28 символов. Введите ZIP код: ");
        }
        if (!newZipCode.isEmpty()) {
            Address newAddress = organizationToUpdate.getOfficialAddress();
            newAddress.setZipCode(newZipCode);
            organizationToUpdate.setOfficialAddress(newAddress);
        }

        System.out.println("Организация обновлена: " + organizationToUpdate);

        // Сортировка коллекции после обновления
        LinkedHashSet<Organization> sortedOrganizations = sortAT(organizations);

        System.out.println("\nСодержимое коллекции после обновления (автоматическая сортировка):");
        for (Organization org : sortedOrganizations) {
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
