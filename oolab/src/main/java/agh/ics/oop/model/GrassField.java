package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Set;

public class GrassField extends AbstractWorldMap {
    private final int grassUpperRange;
    private HashMap<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int grassQauntity) {
        super();
        super.lowerLeft = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        super.upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        grassUpperRange = (int) Math.sqrt(grassQauntity * 10);

        placeGrass(grassQauntity);
    }

    void placeGrass(int grassQuantity) {
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(grassUpperRange, grassUpperRange, grassQuantity);
        for (Vector2d grassPosition : randomPositionGenerator) {
            grasses.put(grassPosition, new Grass(grassPosition));
        }
    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        if(super.isOccupied(position)){
            return super.objectAt(position);
        } else {
            return grasses.get(position);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grasses.containsKey(position);
    }

    Vector2d checkLowerLeft() {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for( Vector2d position: this.animals.keySet() ){
            minX = Math.min(minX, position.getX());
            minY = Math.min(minY, position.getY());
        }

        for(Vector2d position: this.grasses.keySet()){
            minX = Math.min(minX, position.getX());
            minY = Math.min(minY, position.getY());
        }

        return new Vector2d(minX, minY);
    }
    Vector2d checkUpperRight() {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for( Vector2d position: this.animals.keySet() ){
            maxX = Math.max(maxX, position.getX());
            maxY = Math.max(maxY, position.getY());
        }

        for(Vector2d position: this.grasses.keySet()){
            maxX = Math.max(maxX, position.getX());
            maxY = Math.max(maxY, position.getY());
        }

        return new Vector2d(maxX, maxY);
    }

    public String toString(){
        return super.toString(checkLowerLeft(), checkUpperRight());
    }

    @Override
    public Set<WorldElement> getElements() {
        Set<WorldElement> elements = super.getElements();
        elements.addAll(grasses.values());
        return elements;
    }

    int getGrassSize(){
        return grasses.size();
    }
}