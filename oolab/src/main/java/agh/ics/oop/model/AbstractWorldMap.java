package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap{
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapVisualizer visualizer;
    protected ArrayList<MapChangeListener> listeners = new ArrayList<>();

    public Set<WorldElement> getElements() {
        return new HashSet<>(animals.values());
    }

    public AbstractWorldMap() {
        visualizer = new MapVisualizer(this);
        listeners = new ArrayList<>();
    }

    public String toString() {
        Boundary boundaries = getCurrentBounds();
        return visualizer.draw(boundaries.lowerLeft(), boundaries.upperRight());
    }
    @Override
    public void place(Animal animal) throws PositionAlreadyOccupiedException {
        if(canMoveTo(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            mapChanged(animal, null, animal.getPosition());
        }else {
            throw new PositionAlreadyOccupiedException(animal.getPosition());
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animals.remove(animal.getPosition());
        animal.move(direction, this);
        animals.put(animal.getPosition(), animal);
        mapChanged(animal, oldPosition, animal.getPosition());
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(animals.containsKey(position));
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    public void addListener(MapChangeListener listener) {
        listeners.add(listener);
    }

    public void removeListener(MapChangeListener listener) {
        listeners.remove(listener);
    }

    private void mapChanged(Animal animal, Vector2d oldPosition, Vector2d newPosition) {
        String action = (oldPosition == null) ? "placed at" : "moved from " + oldPosition + " to";
        String result = String.format("Animal %s %s %s", animal, action, newPosition);
        for (MapChangeListener listener : listeners) {
            listener.mapChanged(this, result);
        }
    }
    public abstract Boundary getCurrentBounds();
}