package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlElement(name = "zipCode")
    private String zipCode; //Длина строки не должна быть больше 28, Поле может быть null

//    public Address() throws IllegalArgumentException {
//        if (zipCode.length()>28){
//            throw new IllegalArgumentException("length zipCode must be less then 28");
//        }
//        this.zipCode = zipCode;
//    }

    public Address(){}

    //отдельная валидация данных
    public void validate(){
        if (zipCode.length()>28){
            throw new IllegalArgumentException("length zipCode must be less then 28");
        }
    }

    public Address(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
