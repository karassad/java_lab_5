package model;

import java.time.LocalDateTime;
import jakarta.xml.bind.annotation.*;

@XmlRootElement (name = "organization") //устанавливаем класс корневым элементов xml файла
@XmlAccessorType(XmlAccessType.FIELD) //напрямую обращается к полям класса. Необязательно иметь геттеры и сеттеры

public class Organization {

    @XmlElement (name = "id")
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement (name = "name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement (name = "coordinates")
    private Coordinates coordinates; //Поле не может быть null
    @XmlTransient //выключаем парсинг поля
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @XmlElement (name = "annualTurnover")
    private Double annualTurnover; //Поле не может быть null, Значение поля должно быть больше 0
    @XmlElement (name = "type")
    private OrganizationType type; //Поле может быть null
    @XmlElement (name = "officialAddress")
    private Address officialAddress; //Поле не может быть null

    public Organization(Integer id, String name, Coordinates coordinates, LocalDateTime creationDate, Double annualTurnover, OrganizationType type, Address officialAddress) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.annualTurnover = annualTurnover;
        this.type = type;
        this.officialAddress = officialAddress;
    }
    public Organization(){
        this.creationDate = LocalDateTime.now();
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
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setAnnualTurnover(Double annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
    }
}