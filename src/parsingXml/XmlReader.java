package parsingXml;

import model.Address;
import model.Coordinates;
import model.Organization;
import model.OrganizationType;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher; //поиск по регулярным выражениям (Паттернам)
import java.util.regex.Pattern;

import java.time.LocalDateTime;


public class XmlReader {

    private static int nextId = 1; //статик, чтобы гарантировать уникальность айди

    //принимает на вход содержимое файла и возвращает набор объектов set
    public static Set<Organization> parseXml(String xmlContent){
        Set<Organization> organizations = new LinkedHashSet<>(); //создали пустую коллекцию

        Pattern orgPattern = Pattern.compile("<organization>(.*?)<organization>"); //установили регул выраж для тега
        Matcher orgMatcher = orgPattern.matcher(xmlContent);

        while (orgMatcher.find()){ //цикл работает, пока мэтчер находит наш тег
            String orgXml = orgMatcher.group(1); //возвращает часть строки, которая соотвествует 1 группе захвата: (.*?)
            Organization organization = parseOrganization(orgXml); //создаем объект типа organization
            organizations.add(organization); //обавляем в сет
        }
        return organizations;
    }


    //метод, возвращающий объект типа организации из переданного ему куска xml текста
    private static  Organization parseOrganization(String organizationXml){
        Organization organization = new Organization(); //создаем без полей, потом добaвим из парсинга

        int newId = generateId(); //генерим уникальный айдишник
        organization.setId(newId);

        organization.setName(extraxtValue(organizationXml, "name")); //извлекаем знач тега, перводим в инт, подставляем в поле объекта

        Coordinates coordinates = new Coordinates();
        coordinates.setX(Double.parseDouble(extraxtValue(organizationXml, "x")));
        coordinates.setY(Integer.parseInt(extraxtValue(organizationXml, "y")));
        organization.setCoordinates(coordinates);

        organization.setCreationDate(LocalDateTime.now()); //устаанавливаем текущую дату и время

        organization.setAnnualTurnover(Double.parseDouble(extraxtValue(organizationXml, "annualTurnover")));

        //с помощью valueOf приводит (при наличии данного типа в энуме) стринг в константу
        organization.setType(OrganizationType.valueOf(extraxtValue(organizationXml, "type")));

        Address address = new Address();
        address.setZipCode(extraxtValue(organizationXml, "zipCode"));

        return organization;

    }


    //извлекает знач из указанного тега
    private static String extraxtValue(String xml, String tag){
        Pattern pattern = Pattern.compile("<" + tag + ">(.*?)</");
        Matcher matcher = pattern.matcher(xml);

        if (matcher.find()){
            return matcher.group(1); //возвращаем содержимое между указанными тегами
        }
        return "Данные теги не найдены";
    }


    private static  int generateId(){
        return nextId++;
    }
}