package сomandContainer;

import interfaces.Command;
import model.Organization;
import model.OrganizationType;

import java.util.LinkedHashSet;

/** класс для подсчета типов, чья буква находится по алфавиту
 * раньше введенной
 */


public class FilterLessThanTypeCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        if (args.length < 1) {
            System.out.println("Необходимо указать тип для фильтрации.");
            return;
        }

        String typeFilter = args[0]; //  тип передан как строка,

        // Извлекаем тип для фильтрации
        OrganizationType filterType = OrganizationType.valueOf(args[0].toUpperCase());

        // Получаем первую букву в алфавитном порядке от каждого типа организации
        char filterLetter = typeFilter.charAt(0);


        // Фильтруем по первой букве типа и подсчитываем количество
        long count = organizations.stream()
                //substring - 0 - начало подстроки, 1 - конец не включит (ппервая буква)
                .filter(org -> org.getType().name().substring(0, 1).compareTo(filterType.name().substring(0, 1)) < 0) // Сравниваем первую букву типа
                .peek(org -> System.out.println(org)) // Выводим организации
                .count(); // Считаем, сколько таких организаций

        if (count == 0) {
            System.out.println("Нет организаций, удовлетворяющих условию.");
        } else {
            System.out.println("Количество организаций, чьи типы начинаются на букву меньше " + filterLetter + ": " + count);
        }

        System.out.println("Количество организаций с типом, чья первая буква меньше " + filterType.name().substring(0, 1) + ": " + count);
    }
}
