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

        System.out.println("\nКоллекция организаций (отсортировано по ID):");
        System.out.println("------------------------------------------------------------");
        System.out.println("ID  Название             Координаты    Оборот       Тип");
        System.out.println("------------------------------------------------------------");

        for (Organization org : organizationList) {
            System.out.printf("%-3d %-20s (%-4.1f,%-3d) %-10.2f %-12s %s%n",
                    org.getId(),
                    org.getName(),
                    org.getCoordinates().getX(),
                    org.getCoordinates().getY(),
                    org.getAnnualTurnover(),
                    org.getType(),
                    org.getOfficialAddress().getZipCode() != null ?
                            org.getOfficialAddress().getZipCode() : "нет");
        }

        System.out.println("------------------------------------------------------------");
    }

    @Override
    public int compare(Organization o1, Organization o2) {
        return 0;
    }
}
