package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractWorldMap implements WorldMap{
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    protected MapVisualizer visualizer;

    public Set<WorldElement> getElements() {
        return new HashSet<>(animals.values());
    }

    public AbstractWorldMap() {
        visualizer = new MapVisualizer(this);
    }

    public String toString(Vector2d lowerLeft, Vector2d upperRight) {
        return visualizer.draw(lowerLeft, upperRight);
    }
    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        animals.put(animal.getPosition(), animal);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight) && !(animals.containsKey(position));
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }
}