package сomandContainer.useCollection;

import interfaces.Command;
import model.Organization;
import model.Coordinates;
import model.Address;
import model.OrganizationType;

import java.util.LinkedHashSet;
import java.util.Scanner;

import static sort.SortByAT.sortAT;

/**
 * Команда для добавления нового элемента в коллекцию.
 */
public class AddCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод имени организации
        System.out.print("Введите имя организации: ");
        String name = scanner.nextLine();

        while (name == null || name.isEmpty()) {
            System.out.print("Имя не может быть пустым. Введите имя организации: ");
            name = scanner.nextLine();
        }

        // Ввод координат
        System.out.print("Введите координаты (X): ");
        Double x = scanner.nextDouble();

        while (x == null) {
            System.out.print("X не может быть пустым. Введите X: ");
            x = scanner.nextDouble();
        }

        System.out.print("Введите координаты (Y): ");
        int y = scanner.nextInt();

        while (y > 132) {
            System.out.print("Y не может быть больше 132. Введите Y: ");
            y = scanner.nextInt();
        }

        // Создание объекта Coordinates
        Coordinates coordinates = new Coordinates();
        coordinates.setX(x);
        coordinates.setY(y);

        // Ввод годового оборота
        System.out.print("Введите годовой оборот: ");
        Double annualTurnover = 0.0;
        annualTurnover = scanner.nextDouble();
        while (annualTurnover == null || annualTurnover <= 0) {
            if (annualTurnover <= 0) {
                System.out.print("Годовой оборот должен быть больше 0. Попробуйте снова: ");
                annualTurnover = Double.parseDouble(scanner.nextLine());
            } else {
                System.out.print("Некорректный ввод, введите годовой оборот снова: ");
                annualTurnover = Double.parseDouble(scanner.nextLine());
            }
        }

        // Ввод типа организации
        System.out.println("Выберите тип организации: ");
        for (OrganizationType type : OrganizationType.values()) {
            System.out.println(type);
        }

        OrganizationType type = null;
        while (type == null) {
            try {
                String typeInput = scanner.nextLine().toUpperCase();
                type = OrganizationType.valueOf(typeInput);
            } catch (IllegalArgumentException e) {
                System.out.print("Некорректный ввод, выберите тип из списка: ");
            }
        }

        // Ввод адреса (ZIP-код)
        System.out.print("Введите ZIP код (можно оставить пустым): ");
        String zipCode = scanner.nextLine().trim();
        Address address = new Address();
        address.setZipCode(zipCode.isEmpty() ? null : zipCode);

        // Создание объекта Organization
        Organization newOrg = new Organization();
        newOrg.setName(name);
        newOrg.setCoordinates(coordinates);
        newOrg.setAnnualTurnover(annualTurnover);
        newOrg.setType(type);
        newOrg.setOfficialAddress(address);

        // Добавляем объект в коллекцию
        organizations.add(newOrg);
        System.out.println("Элемент добавлен: " + newOrg.toString());

        LinkedHashSet<Organization> sortednewOrganizations = sortAT(organizations);

        System.out.println("\nСодержимое коллекции после добавления (автоматическая сортировка):");
        for (Organization org : sortednewOrganizations) {
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
