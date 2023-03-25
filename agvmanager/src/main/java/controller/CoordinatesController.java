package controller;

import domain.Coordinates;

public class CoordinatesController {
    public Coordinates createCoordinates(int xPos, int yPos) {
        return new Coordinates(xPos, yPos);
    }
}