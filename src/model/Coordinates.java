package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "coordinates")
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {

    @XmlElement(name = "x")
    private Double x; //Поле не может быть null
    @XmlElement (name = "y")
    private int y; //Максимальное значение поля: 132

    public Coordinates(Double x, int y) {
        this.y = y;
        this.x = x;
    }


    public Coordinates() {
    }

    public void validate() {
        if (x == null) {
            throw new IllegalArgumentException("Значение x не может быть null");
        }
        if (y > 132) {
            throw new IllegalArgumentException("Значение y не может быть more then 132");
        }
    }

    public int getY() {
        return y;
    }

    public Double getX() {
        return x;
    }

    public void setY(int y) {
        if (y > 132) {
            throw new IllegalArgumentException("Значение y не может быть больше 132");
        }
        this.y = y;
    }

    public void setX(Double x) {
        if (x == null) {
            throw new IllegalArgumentException("Значение x не может быть null");
        }
        this.x = x;
    }
}