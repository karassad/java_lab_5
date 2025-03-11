package сomandContainer.useCollection;

import interfaces.Command;
import model.Organization;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveGreaterCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        if (args.length < 1) {
            System.out.println("Необходимо указать элемент для сравнения.");
            return;
        }

        // элемент, с которым будем сравнивать, передается в виде строки
        try {
            // используем оборот как критерий
            Double compareTurnover = Double.parseDouble(args[0]);

            // Итератор для удаления элементов
            Iterator<Organization> iterator = organizations.iterator();

            //hasNext - возвращает True, если в коллекции еще есть элементы
            while (iterator.hasNext()) {
                //next - получаем след элемент
                Organization organization = iterator.next();

                // Удаляем организации, чей годовой оборот больше заданного
                if (organization.getAnnualTurnover() > compareTurnover) {
                    iterator.remove();
                }
            }

            System.out.println("Элементы, превышающие заданный, были удалены.");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка при передаче элемента для сравнения. Пожалуйста, укажите числовое значение.");
        }
    }
}
