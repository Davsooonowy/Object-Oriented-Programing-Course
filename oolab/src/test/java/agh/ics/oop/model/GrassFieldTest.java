package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrassFieldTest {

    @Test
    void plantGrassTest() {
        GrassField map = new GrassField(10);
        assertEquals(10, map.getGrassSize());
    }
    @Test
    public void isOccupiedTest(){
        GrassField map = new GrassField(10);
        map.place(new Animal(new Vector2d(1,1),MapDirection.NORTH));
        assertEquals(map.isOccupied(new Vector2d(1,1)),true);
        assertEquals(map.isOccupied(new Vector2d(1,2)),false);
        assertEquals(map.isOccupied(new Vector2d(3,3)),false);
    }

    @Test
    public void objectAtTest(){
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(1,0), MapDirection.NORTH);
        Animal animal2 = new Animal(new Vector2d(2,2), MapDirection.NORTH);
        map.place(animal1);
        map.place(animal2);
        assertEquals(map.objectAt(new Vector2d(1,0)),animal1);
        assertEquals(map.objectAt(new Vector2d(2,2)),animal2);
        assertEquals(map.objectAt(new Vector2d(3,3)),null);
    }

    @Test
    public void testCheckLowerLeft() {
        GrassField grassField = new GrassField(10); // Example grass field with 10 grass instances

        grassField.place(new Animal(new Vector2d(9, 9), MapDirection.NORTH));
        grassField.place(new Animal(new Vector2d(0, 0), MapDirection.NORTH));

        Vector2d lowerLeft = grassField.checkLowerLeft();
        Vector2d expectedLowerLeft = new Vector2d(0, 0);
        assertEquals(expectedLowerLeft, lowerLeft);

        Vector2d upperRight = grassField.checkUpperRight();
        Vector2d expectedUpperRight = new Vector2d(9, 9);
        assertEquals(expectedUpperRight, upperRight);
    }

    @Test
    void testGetElements() {
        GrassField grassField = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(3, 3), MapDirection.NORTH);
        Animal animal2 = new Animal(new Vector2d(4, 3), MapDirection.NORTH);
        Animal animal3 = new Animal(new Vector2d(5, 3), MapDirection.NORTH);
        grassField.place(animal1);
        grassField.place(animal2);
        grassField.place(animal3);

        Set<WorldElement> elements = grassField.getElements();

        assertTrue(elements.contains(animal1));
        assertTrue(elements.contains(animal2));
        assertTrue(elements.contains(animal3));

        int count = 0;
        for (WorldElement s : elements) {
            if (s.toString().equals("*")) {
                count++;
            }
        }
        assertEquals(10, count);

        assertEquals(13, elements.size());
    }
}