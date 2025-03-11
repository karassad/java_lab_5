package сomandContainer.useCollection;

import interfaces.Command;
import model.Organization;

import java.util.LinkedHashSet;

public class ClearCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        // Очистка коллекции
        organizations.clear();

        // Вывод сообщения об успешной очистке коллекции
        System.out.println("Коллекция успешно очищена.");

//        // Вывод содержимого коллекции после очистки
//        System.out.println("\nСодержимое коллекции после очистки:");
//        if (organizations.isEmpty()) {
//            System.out.println("Коллекция пуста.");
//        } else {
//            for (Organization org : organizations) {
//                System.out.println("ID: " + org.getId());
//                System.out.println("Name: " + org.getName());
//                System.out.println("Coordinates: (" + org.getCoordinates().getX() + ", " + org.getCoordinates().getY() + ")");
//                System.out.println("Annual Turnover: " + org.getAnnualTurnover());
//                System.out.println("Type: " + org.getType());
//                System.out.println("ZIP Code: " + org.getOfficialAddress().getZipCode());
//                System.out.println();
//            }
//        }
    }
}
