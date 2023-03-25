package domain;

import java.io.Serializable;

public class Coordinates implements Serializable, Bytable<Coordinates> {
    private int xPos;
    private int yPos;

    public Coordinates(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Coordinates() {
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    @Override
    public String toString() {
        return "[" + xPos + "][" + yPos + "]";
    }
}