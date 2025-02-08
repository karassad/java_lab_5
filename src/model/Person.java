package model;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Double weight; //Поле не может быть null, Значение поля должно быть больше 0
    private Location location; //Поле может быть null

    public Person(String name, Double weight, Location location) {
        this.name = name;
        this.weight = weight;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Location getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}