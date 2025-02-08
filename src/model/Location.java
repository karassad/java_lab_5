package model;

public class Location {
    private int x;
    private float y;
    private Integer z; //Поле не может быть null

    public Location(float y, int x, Integer z) {
        this.y = y;
        this.x = x;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(Integer z) {
        this.z = z;
    }
}
