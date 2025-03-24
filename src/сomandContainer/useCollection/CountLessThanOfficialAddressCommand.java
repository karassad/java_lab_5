package сomandContainer.useCollection;

import interfaces.Command;
import model.Organization;
import model.Address;

import java.util.LinkedHashSet;


public class CountLessThanOfficialAddressCommand implements Command {

    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        // Проверка аргументов
        if (args == null || args.length == 0) {
            System.out.println("Ошибка: укажите ZIP-код для сравнения");
            return;
        }

        // Подготовка адреса для сравнения
        Address compareAddress = new Address();
        compareAddress.setZipCode(args[0]);

        int count = 0;

        // Простой перебор for-each
        for (Organization org : organizations) {
            try {
                Address orgAddress = org.getOfficialAddress();
                if (orgAddress != null && orgAddress.compareTo(compareAddress) < 0) {
                    count++;
                }
            } catch (NullPointerException e) {
                System.out.println("Пропущена организация с ID " + org.getId() +
                        " (отсутствует адрес)");
            } catch (Exception e) {
                System.out.println("Ошибка при обработке организации с ID " + org.getId() +
                        ": " + e.getMessage());
            }
        }

        System.out.println("Найдено организаций: " + count);
    }
}

