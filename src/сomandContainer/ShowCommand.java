//package сomandContainer;
//
//import interfaces.Command;
//import model.Organization;
//
//import java.util.LinkedHashSet;
//
///**
// * Команда для вывода всех элементов коллекции.
// */
//public class ShowCommand implements Command {
//
//    @Override
//    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
//        for (Organization org : organizations) {
//            System.out.println(org.toString()); // Строковое представление объекта
//        }
//    }
//
//
//}

package сomandContainer;

import interfaces.Command;
import model.Organization;
import model.Coordinates;
import model.Address;

import java.util.LinkedHashSet;

/**
 * Команда для красивого вывода всех элементов коллекции в табличном формате.
 */
public class ShowCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        if (organizations.isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }

        // Выводим заголовок таблицы
        printTableHeader();

        // Выводим данные каждой организации
        for (Organization org : organizations) {
            printOrganization(org);
        }

    }

    private void printTableHeader() {
        System.out.println("+----+----------------------+------------+------------+------------------+----------------------+----------------+");
        System.out.println("| ID |        Name          | Coordinates| Create Date| Annual Turnover  |        Type          |    ZIP Code    |");
        System.out.println("+----+----------------------+------------+------------+------------------+----------------------+----------------+");
    }

    private void printOrganization(Organization org) {
        Coordinates coord = org.getCoordinates();
        Address addr = org.getOfficialAddress();

        // Форматируем каждое поле для красивого вывода
        String id = String.format("| %-2d ", org.getId());
        String name = String.format("| %-20s ", org.getName());
        String coordinates = String.format("| (%5.2f,%-3d) ", coord.getX(), coord.getY());
        String createDate = String.format("| %-10s ", org.getCreationDate().toLocalDate());
        String turnover = String.format("| %-16.2f ", org.getAnnualTurnover());
        String type = String.format("| %-20s ", org.getType() != null ? org.getType() : "null");
        String zipCode = String.format("| %-14s |", addr.getZipCode() != null ? addr.getZipCode() : "null");

        System.out.println(id + name + coordinates + createDate + turnover + type + zipCode);
    }

}