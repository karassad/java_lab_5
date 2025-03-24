package сomandContainer.useCollection;

import model.*;
import interfaces.Command;

import java.util.LinkedHashSet;

public class AddIfMinCommand implements Command {



    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        if (args.length != 1) {
            System.out.println("Необходимо указать значение annualTurnover для нового элемента.");
            return;
        }

        // Извлекаем значение оборота для нового объекта
        Double annualTurnover;
        try {
            annualTurnover = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: не удалось преобразовать значение в число для оборота.");
            return;
        }


        // Создаем координаты с дефолтными значениями
        Coordinates coordinates = new Coordinates(0.0, 0);  // x=0.0, y=0

        // Создаем адрес (можно задать или оставить null)
        Address address = new Address();
        address.setZipCode(null);  // или установить конкретный ZIP-код

        // Создаем новую организацию
        Organization newOrganization = new Organization();
        newOrganization.setName("New Organization");  // можно сделать ввод имени
        newOrganization.setCoordinates(coordinates);
        newOrganization.setAnnualTurnover(annualTurnover);
        newOrganization.setType(OrganizationType.COMMERCIAL);  // или другой тип
        newOrganization.setOfficialAddress(address);

        // Добавляем, если оборот минимальный
        addIfMin(organizations, newOrganization);

        // Добавляем элемент в коллекцию, если его annualTurnover меньше минимального оборота
        addIfMin(organizations, newOrganization);
    }

    private void addIfMin(LinkedHashSet<Organization> organizations, Organization newOrganization) {
        // Находим минимальный элемент по annualTurnover
        Organization minOrganization = organizations.stream()
                .min(Organization::compareTo)
                .orElse(null);

        // Если коллекция пуста или новый элемент имеет меньший annualTurnover, добавляем его
        if (minOrganization == null || newOrganization.compareTo(minOrganization) < 0) {
            organizations.add(newOrganization);
            System.out.println("Элемент добавлен в коллекцию, так как его annualTurnover меньше минимального.");
        } else {
            System.out.println("Новый элемент не добавлен, так как его annualTurnover не меньше минимального.");
        }
    }
}
