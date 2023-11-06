package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;
import java.util.ArrayList;

public class Simulation {
    private  List<Animal> animals = new ArrayList<>();
    private  List<MoveDirection> directions;
    private List<Vector2d> coordinates;
    private WorldMap<Animal, Vector2d> map;
    public Simulation(List<MoveDirection> directions, List<Vector2d> coordinates, WorldMap<Animal, Vector2d> map) {
        this.directions = directions;
        this.coordinates = coordinates;
        this.map = map;
        addAnimals();
    }

    private void addAnimals() {
        for (Vector2d move : coordinates) {
            Animal animal = new Animal(move, MapDirection.NORTH);
            animals.add(animal);
            map.place(animal);
        }
    }
    Animal getAnimal(int i){
        return animals.get(i);
    }

    public void run() {
        for (int i = 0; i < directions.size(); i++) {
            Animal animal = animals.get(i % animals.size());
            MoveDirection direction = directions.get(i);
            map.move(animal, direction);
            map.place(animal);
            System.out.println(map.toString());
        }
    }
}
