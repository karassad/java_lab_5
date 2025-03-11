package сomandContainer.useCollection;

import interfaces.Command;
import model.Organization;
import model.Address;

import java.util.LinkedHashSet;


public class CountLessThanOfficialAddressCommand implements Command {

//    public void execute(Linked)


    // Метод для подсчета количества организаций с officialAddress, меньшими заданного
    public void execute(LinkedHashSet<Organization> organizations, Address address) {
        long count = organizations.stream()
                .filter(org -> org.getOfficialAddress().compareTo(address) < 0)  // Сравниваем адреса
                .count();

        System.out.println("Количество организаций с officialAddress, меньшим заданного: " + count);
    }

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {

    }
}

