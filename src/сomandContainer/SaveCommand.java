package сomandContainer;

import interfaces.Command;
import model.Address;
import model.Coordinates;
import model.Organization;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import model.OrganizationType;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class SaveCommand implements Command {

    @Override
    public void execute(LinkedHashSet<Organization> organizations, String[] args) {
        try {
            // Преобразуем LinkedHashSet в List для сериализации
            List<Organization> organizationList = new ArrayList<>(organizations);

            // Создание JAXB контекста для сериализации в XML
//            JAXBContext context = JAXBContext.newInstance(Organization.class, OrganizationListWrapper.class);
            JAXBContext context = JAXBContext.newInstance(
                    Organization.class,
                    OrganizationListWrapper.class,
                    Coordinates.class,
                    Address.class,
                    OrganizationType.class
            );


            // Создание Marshaller для преобразования объектов в XML
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //читаемость XML. Отступы, переносы строк

            // Создание BufferedOutputStream для записи в файл
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:/Users/kladm/ITMO/IntelliJ IDEA JAVA/java_lab_5/src/resources/newList.xml"))) {
                // Оборачиваем всю коллекцию в контейнер (переводим из коллекции в корневой элемент)
                OrganizationListWrapper wrapper = new OrganizationListWrapper(organizationList);

                // Запись в файл
                marshaller.marshal(wrapper, bos);
                System.out.println("Коллекция успешно сохранена в файл organizations.xml");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка при сериализации в XML: " + e.getMessage());
        }
    }
}

// Вспомогательный класс для того, чтобы JAXB мог сериализовать коллекцию объектов Organization в XML.
@XmlRootElement(name = "organizations")
class OrganizationListWrapper {
    private List<Organization> organizations;

    public OrganizationListWrapper(){};

    public OrganizationListWrapper(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @XmlElementWrapper(name = "organizationList")  // Упаковка коллекции в элемент <organizationList>
    @XmlElement(name = "organization")  // Каждый элемент коллекции будет сериализован как <organization>
    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
}
