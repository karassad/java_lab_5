package сomandContainer.useCollection;

import interfaces.Command;
import model.Organization;
import java.util.LinkedHashSet;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Класс для вывода элементов коллекции в порядке возрастания по ID.
 */
public class PrintAscendingCommand implements Command, Comparator<Organization> {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        if (organizations.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }

        // Преобразуем LinkedHashSet в список, чтобы использовать Collections.sort
        List<Organization> organizationList = new ArrayList<>(organizations);

        // Сортировка с использованием анонимного класса Comparator
        Collections.sort(organizationList, new Comparator<Organization>() {
            public int compare(Organization org1, Organization org2) {
                return org1.getId().compareTo(org2.getId());
            }
        });

        // Выводим отсортированные организации
        for (int i = 0; i < organizationList.size(); i++) {
            System.out.println(organizationList.get(i));
        }

        // Дополнительное сообщение (необязательно)
        System.out.println("Элементы коллекции отсортированы в порядке возрастания по ID.");
    }

    @Override
    public int compare(Organization o1, Organization o2) {
        return 0;
    }
}
