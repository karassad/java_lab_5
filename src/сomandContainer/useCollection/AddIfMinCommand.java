package сomandContainer.useCollection;

import interfaces.Command;
import model.Organization;

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

        // Создаем новый объект Organization с этим значением оборота
        Organization newOrganization = new Organization(null, "New Organization", null, null, annualTurnover, null, null);

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
