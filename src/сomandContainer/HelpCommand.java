package сomandContainer;

import interfaces.Command;
import model.Organization;

import java.util.LinkedHashSet;

public class HelpCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args){
        System.out.println("Доступные команды:");
        System.out.println("help : вывести справку по доступным командам");
        System.out.println("info : вывести информацию о коллекции");
        System.out.println("show : вывести все элементы коллекции");
        System.out.println("add {element} : добавить новый элемент в коллекцию");
        System.out.println("update id {element} : обновить элемент по id");
        System.out.println("remove_by_id id : удалить элемент по id");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script file_name : исполнить скрипт");
        System.out.println("exit : завершить программу");
        System.out.println("add_if_min {element} : добавить элемент, если он меньше наименьшего");
        System.out.println("remove_greater {element} : удалить элементы больше заданного");
        System.out.println("remove_lower {element} : удалить элементы меньше заданного");
        System.out.println("count_less_than_official_address officialAddress : посчитать элементы по адресу");
        System.out.println("filter_less_than_type type : отфильтровать элементы по типу");
        System.out.println("print_ascending : вывести элементы по возрастанию");
    }
}
