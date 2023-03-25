package domain;

import controller.CoordinatesController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinatesTest {
    @Test
    public void coordinatesTest() {
        int xPos = 88;
        int yPos = 33;

        Coordinates coordinates = new Coordinates(xPos, yPos);

        assertEquals(xPos, coordinates.getxPos());
        assertEquals(yPos, coordinates.getyPos());

        coordinates = new CoordinatesController().createCoordinates(xPos, yPos);

        assertEquals(xPos, coordinates.getxPos());
        assertEquals(yPos, coordinates.getyPos());
    }

    @Test
    public void byteAble() {
        int xPos = 88;
        int yPos = 33;

        Coordinates coordinates = new Coordinates(xPos, yPos);

        byte[] bytes = coordinates.getBytes(coordinates);
        Coordinates object = new Coordinates().getObject(bytes);

        assertEquals(coordinates.getxPos(), object.getxPos());
        assertEquals(coordinates.getyPos(), object.getyPos());
    }
}