package model;

public class Coordinates {
    private Double x; //Поле не может быть null
    private int y; //Максимальное значение поля: 132

    public Coordinates(Double x, int y) {
        this.y = y;
        this.x = x;
    }

    public Coordinates(){}

    public int getY() {
        return y;
    }

    public Double getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(Double x) {
        this.x = x;
    }
}