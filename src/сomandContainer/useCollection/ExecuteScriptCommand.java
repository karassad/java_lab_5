package сomandContainer.useCollection;

import interfaces.Command;
import model.Organization;
import сomandContainer.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;

public class ExecuteScriptCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        if (args.length != 1) {
            System.out.println("Ошибка: необходимо указать имя файла.");
            return;
        }

        String fileName = args[0];

        // открыть файл и считать команды
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    System.out.println("Исполняется команда: " + line);
                    executeCommand(line, organizations);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Метод для выполнения команд из файла
    private void executeCommand(String command, LinkedHashSet<Organization> organizations) {
        switch (command.toLowerCase()) {
            case "show":
                new ShowCommand().execute(organizations, new String[]{});
                break;
            case "save":
                new SaveCommand().execute(organizations, new String[]{});
                break;
            case "add":
                new AddCommand().execute(organizations, new String[]{});
                break;
            case "clear":
                new ClearCommand().execute(organizations, new String[]{});
                break;
            case "exit":
                new ExitCommand().execute(organizations, new String[]{});
                break;
            case "help":
                new HelpCommand().execute(organizations, new String[]{});
                break;
            case "info":
                new InfoCommand().execute(organizations, new String[]{});
                break;
            case "Remove":
                new RemoveCommand().execute(organizations, new String[]{});
                break;
            case "update":
                new UpdateCommand().execute(organizations, new String[]{});
                break;


            default:
                System.out.println("Неизвестная команда: " + command);
                break;
        }
    }
}
