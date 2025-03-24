package сomandContainer;

import interfaces.Command;
import model.Organization;
import model.OrganizationType;

import java.util.LinkedHashSet;


/**
 * Фильтрует организации, у которых тип начинается на букву, которая в алфавитном порядке
 * идет раньше указанной буквы.
 * Например, если указан тип "COMMERCIAL" (первая буква 'C'),
 * будут найдены организации с типами, начинающимися на 'A', 'B' и т.д., но не на 'C' или позднее.
 */
public class FilterLessThanTypeCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        // Проверка наличия аргумента
        if (args == null || args.length == 0) {
            System.out.println("Ошибка: необходимо указать тип для фильтрации");
            System.out.println("Доступные типы: " + getAvailableTypes());
            return;
        }

        try {
            // Преобразование ввода в enum
            OrganizationType filterType = OrganizationType.valueOf(args[0].toUpperCase());
            char filterLetter = args[0].toUpperCase().charAt(0);

            int count = 0;
            System.out.println("Организации с типом раньше '" + filterType + "':");

            // Перебор без stream API
            for (Organization org : organizations) {
                try {
                    if (org.getType() != null) {
                        char orgLetter = org.getType().name().charAt(0);
                        if (orgLetter < filterLetter) {
                            System.out.println(formatOrganization(org));
                            count++;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка при обработке организации ID " + org.getId() + ": " + e.getMessage());
                }
            }

            if (count == 0) {
                System.out.println("Нет организаций, удовлетворяющих условию.");
            } else {
                System.out.println("Всего найдено: " + count);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: '" + args[0] + "' не является допустимым типом");
            System.out.println("Доступные типы: " + getAvailableTypes());
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());
        }
    }

    private String getAvailableTypes() {
        StringBuilder sb = new StringBuilder();
        for (OrganizationType type : OrganizationType.values()) {
            sb.append(type.name()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    private String formatOrganization(Organization org) {
        return String.format("ID: %-3d | Тип: %-12s | Название: %-20s",
                org.getId(), org.getType(), org.getName());
    }
}