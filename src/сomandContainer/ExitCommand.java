package сomandContainer;

import interfaces.Command;
import model.Organization;
import java.util.LinkedHashSet;

/**
 * Команда для завершения программы.
 */
public class ExitCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        System.out.println("Завершаем программу...");
        System.exit(0);  // Завершаем программу
    }
}