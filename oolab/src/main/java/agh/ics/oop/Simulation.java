package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.List;
import java.util.ArrayList;

public class Simulation {
    private  List<Animal> animals = new ArrayList<>();
    private  List<MoveDirection> directions;
    private List<Vector2d> coordinates;
    public Simulation(List<MoveDirection> directions, List<Vector2d> coordinates) {
        this.directions = directions;
        this.coordinates = coordinates;
        addAnimals();
    }

    private void addAnimals() {
        for (Vector2d move : coordinates) {
            Animal animal = new Animal(move, MapDirection.NORTH);
            animals.add(animal);
        }
    }
    public Animal getAnimal(int i){
        return animals.get(i);
    }

    public void run() {
        for(int i = 0; i < directions.size(); i++){
            animals.get(i % animals.size()).move(directions.get(i));
            System.out.println("Zwierzę " + i % animals.size() + animals.get(i % animals.size()).toString());
        }
    }
}
