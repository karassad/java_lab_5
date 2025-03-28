package model;

import java.time.LocalDateTime;
import java.util.Objects;

import FileManage.LocalDateTimeAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement (name = "organization") //устанавливаем класс корневым элементов xml файла
@XmlAccessorType(XmlAccessType.FIELD) //напрямую обращается к полям класса. Необязательно иметь геттеры и сеттеры

public class Organization implements Comparable<Organization> {

//    @XmlTransient
    @XmlElement (name = "id")
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement (name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement (name = "coordinates")
    private Coordinates coordinates; //Поле не может быть null
//    @XmlTransient //выключаем парсинг поля
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    @XmlElement (name = "creationDate")
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @XmlElement (name = "annualTurnover")
    private Double annualTurnover; //Поле не может быть null, Значение поля должно быть больше 0
    @XmlElement (name = "type")
    private OrganizationType type; //Поле может быть null
    @XmlElement (name = "officialAddress")
    private Address officialAddress; //Поле не может быть null

    private static int idCounter = 100;

    public Organization(Integer id, String name, Coordinates coordinates, LocalDateTime creationDate, Double annualTurnover, OrganizationType type, Address officialAddress) {
        this.id = idCounter++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.officialAddress = officialAddress;
    }
    public Organization(){
        this.creationDate = LocalDateTime.now();
        this.id = idCounter++;
    }

    public void validate() {
        // Проверка обязательных полей
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name не должен быть пустым");
        }
        if (annualTurnover <= 0) {
            throw new IllegalArgumentException("Годовой оборот должен быть > 0");
        }
        if (annualTurnover == null) {
            throw new IllegalArgumentException("Годовой оборот не должен быть равен null");
        }
        if (type == null) {
            throw new IllegalArgumentException("Type не должен быть равен null");
        }
        //вызов валидации координат и адреса
        officialAddress.validate();
        coordinates.validate();
    }

    public Integer getId() {
        return id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Double getAnnualTurnover() {
        return annualTurnover;
    }

    public OrganizationType getType() {
        return type;
    }

    public Address getOfficialAddress() {
        return officialAddress;
    }

    public void setId(Integer id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID должен быть больше 0");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        }
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Координаты не могут быть null");
        }
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setAnnualTurnover(Double annualTurnover) {
        if (annualTurnover <= 0) {
            throw new IllegalArgumentException("Годовой оборот должен быть больше 0");
        }
        this.annualTurnover = annualTurnover;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public void setOfficialAddress(Address officialAddress) {
        if (officialAddress == null) {
            throw new IllegalArgumentException("Официальный адрес не может быть null");
        }
        this.officialAddress = officialAddress;
    }

    // Метод для обновления id и creationDate после парсинга
    public void updateIdAndCreationDate() {
        this.id = idCounter++;
        this.creationDate = LocalDateTime.now();
    }

    // Реализация интерфейса Comparable для сравнения объектов по полю annualTurnover
    @Override
    public int compareTo(Organization other) {
        // Сравниваем по полю annualTurnover
        return this.annualTurnover.compareTo(other.annualTurnover);
    }


    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", annualTurnover=" + annualTurnover +
                ", type=" + type +
                ", officialAddress=" + officialAddress +
                ", id=" + id +
                '}';
    }
}