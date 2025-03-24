package сomandContainer.useCollection;

import interfaces.Command;
import model.Organization;
import model.Coordinates;
import model.Address;
import model.OrganizationType;

import java.util.LinkedHashSet;
import java.util.Scanner;

import static sort.SortByAT.sortAT;

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

        // Ввод координаты X
        Double x = null;
        while (x == null) {
            System.out.print("Введите координаты (X): ");
            try {
                x = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число для координаты X.");
            }
        }

        // Ввод координаты Y
        Integer y = null;
        while (y == null || y > 132) {
            System.out.print("Введите координаты (Y) (максимум 132): ");
            try {
                y = Integer.parseInt(scanner.nextLine());
                if (y > 132) {
                    System.out.println("Ошибка: Y не может быть больше 132.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число для координаты Y.");
            }
        }

        // Создание объекта Coordinates
        Coordinates coordinates = new Coordinates(x, y);

        // Ввод годового оборота
        Double annualTurnover = null;
        while (annualTurnover == null || annualTurnover <= 0) {
            System.out.print("Введите годовой оборот: ");
            try {
                annualTurnover = Double.parseDouble(scanner.nextLine());
                if (annualTurnover <= 0) {
                    System.out.println("Ошибка: годовой оборот должен быть больше 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число для годового оборота.");
            }
        }

        // Ввод типа организации
        System.out.println("Выберите тип организации: ");
        for (OrganizationType type : OrganizationType.values()) {
            System.out.println(type);
        }

        OrganizationType type = null;
        while (type == null) {
            System.out.print("Введите тип организации: ");
            try {
                type = OrganizationType.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: выберите тип из списка выше.");
            }
        }

        // Ввод адреса
        System.out.print("Введите ZIP код (можно оставить пустым): ");
        String zipCode = scanner.nextLine().trim();
        Address address = new Address();
        address.setZipCode(zipCode.isEmpty() ? null : zipCode);

        // Создание и добавление организации
        Organization newOrg = new Organization();
        newOrg.setName(name);
        newOrg.setCoordinates(coordinates);
        newOrg.setAnnualTurnover(annualTurnover);
        newOrg.setType(type);
        newOrg.setOfficialAddress(address);

        organizations.add(newOrg);

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║               ОРГАНИЗАЦИЯ ДОБАВЛЕНА               ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.printf("║ %-20s: %-25s ║\n", "ID", newOrg.getId());
        System.out.printf("║ %-20s: %-25s ║\n", "Название", newOrg.getName());
        System.out.printf("║ %-20s: (%-5.2f, %-3d) %13s ║\n", "Координаты",
                newOrg.getCoordinates().getX(),
                newOrg.getCoordinates().getY(), "");
        System.out.printf("║ %-20s: %-25s ║\n", "Дата создания",
                newOrg.getCreationDate().toLocalDate());
        System.out.printf("║ %-20s: %-25.2f ║\n", "Годовой оборот",
                newOrg.getAnnualTurnover());
        System.out.printf("║ %-20s: %-25s ║\n", "Тип", newOrg.getType());
        System.out.printf("║ %-20s: %-25s ║\n", "ZIP код",
                newOrg.getOfficialAddress().getZipCode() != null ?
                        newOrg.getOfficialAddress().getZipCode() : "не указан");
        System.out.println("╚══════════════════════════════════════════════════╝");


    }
}