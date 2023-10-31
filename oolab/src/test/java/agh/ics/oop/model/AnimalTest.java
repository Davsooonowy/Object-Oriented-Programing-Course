package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {

    @Test

    void orientation(){ //only orientation test
        Animal animal = new Animal();
        assertEquals(MapDirection.NORTH,animal.getDirection());
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST,animal.getDirection());
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH,animal.getDirection());
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST,animal.getDirection());
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH,animal.getDirection());
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST,animal.getDirection());
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH,animal.getDirection());
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST,animal.getDirection());
    }

    @Test void move_test(){ //only move test and check if an animal does not go beyond the map
        Animal animal = new Animal();
        assertTrue(animal.isAt(new Vector2d(2,2)));
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,3)));
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,4)));
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,3)));
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,0)));
        animal.move(MoveDirection.RIGHT); //i have to turn the animal to check x-direction
        assertEquals(MapDirection.EAST,animal.getDirection()); //control position check
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(3,0)));
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(4,0)));
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(0,0)));
    }

    @Test
    void overall_test(){ //overall test of animal movement
        Animal animal = new Animal();
        assertTrue(animal.isAt(new Vector2d(2,2)));

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST,animal.getDirection());

        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH,animal.getDirection());

        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,3)));

        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,4)));

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,4)));

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(3,4)));

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST,animal.getDirection());
        assertTrue(animal.isAt(new Vector2d(4,4)));

        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.NORTH,animal.getDirection());
        assertTrue(animal.isAt(new Vector2d(4,4)));

        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(4,3)));

        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(4,1)));

        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(4,0)));

        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        assertEquals(MapDirection.NORTH,animal.getDirection());
        assertTrue(animal.isAt(new Vector2d(4,0)));

        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(3,0)));

        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,0)));

        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(1,0)));

        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(0,0)));

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.WEST,animal.getDirection());

        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.BACKWARD);
        assertTrue(animal.isAt(new Vector2d(2,0)));
        assertTrue(animal.isAt(new Vector2d(2,0)));

        animal.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.WEST,animal.getDirection());

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(0,0)));

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.BACKWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(3,1)));
        assertEquals(MapDirection.EAST,animal.getDirection());

        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(2,1)));
        assertEquals(MapDirection.WEST,animal.getDirection());
    }
}