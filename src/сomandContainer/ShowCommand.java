package сomandContainer;

import interfaces.Command;
import model.Organization;

import java.util.LinkedHashSet;

/**
 * Команда для вывода всех элементов коллекции.
 */
public class ShowCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        for (Organization org : organizations) {
            System.out.println(org.toString()); // Строковое представление объекта
        }
    }


}