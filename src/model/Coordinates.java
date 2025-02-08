package model;

public class Coordinates {
    private Float x; //Максимальное значение поля: 597, Поле не может быть null
    private Integer y; //Поле не может быть null

    public Coordinates(Integer y, Float x) {
        this.y = y;
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public Float getX() {
        return x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setX(Float x) {
        this.x = x;
    }
}