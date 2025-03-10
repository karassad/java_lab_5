package сomandContainer;

import interfaces.Command;
import model.Organization;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;

public class InfoCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        System.out.println("Тип коллекции: " + organizations.getClass().getName());
//        System.out.println("Дата инициализации: " + LocalDateTime.now());
        System.out.println("Количество элементов: " + organizations.size());
    }
}