import interfaces.Command;
import model.*;
//import resources.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

import FileManage.XmlParser;
import сomandContainer.*;
import сomandContainer.FilterLessThanTypeCommand;
import сomandContainer.useCollection.*;


public class Main {
    public static void main(String[] args) {

        // Создаем коллекцию команд
        Map<String, Command> commands = new HashMap<>();
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("add", new AddCommand());
        commands.put("update", new UpdateCommand());
        commands.put("remove_by_id", new RemoveCommand());
        commands.put("clear", new ClearCommand());
        commands.put("save", new SaveCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("exit", new ExitCommand());
        commands.put("add_if_min", new AddIfMinCommand());
        commands.put("remove_greater", new RemoveGreaterCommand());
        commands.put("remove_lower", new RemoveLowerCommand());
        commands.put("count_less_than_official_address", new CountLessThanOfficialAddressCommand());
        commands.put("filter_less_than_type", new FilterLessThanTypeCommand());
        commands.put("print_ascending", new PrintAscendingCommand());

        LinkedHashSet<Organization> organizations = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);

        XmlParser parser = new XmlParser();
        String filePath = "C:/Users/kladm/ITMO/IntelliJ IDEA JAVA/java_lab_5/src/resources/test.xml";
//        LinkedHashSet<Organization> organizations = null;
        try {
            organizations = (LinkedHashSet<Organization>) parser.parseXml(filePath);
            for (Organization org : organizations) {
                org.updateIdAndCreationDate();
            }
        } catch (IllegalArgumentException e) {

        }

        // Печатаем приветствие
        System.out.println("Добро пожаловать в интерактивную среду для управления коллекцией.");
        System.out.println("Введите команду (для справки введите 'help'):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim(); //trim - отчистка от пробелов

            // Разделяем введенную строку на команду и аргументы
            String[] inputParts = input.split(" ", 2);
            String commandName = inputParts[0].toLowerCase();
            String arg = inputParts.length > 1 ? inputParts[1] : ""; //проверка на наличие аргументов при вводе

            // Проверяем, существует ли команда в коллекции
            Command command = commands.get(commandName);
            if (command != null) {
                try {
                    // Выполняем команду
                    command.execute(organizations, arg.split(" ")); //передаем аргументы в виле массива
                } catch (Exception e) {
                    System.out.println("Произошла ошибка при выполнении команды: " + e.getMessage());
                }
            } else {
                System.out.println("Неизвестная команда. Введите 'help' для справки.");
            }

    }



    }
}
