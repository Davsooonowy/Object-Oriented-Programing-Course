package agh.ics.oop.model;

public class Animal {
    private MapDirection direction;
    private Vector2d position;
    public Animal(Vector2d initialPosition, MapDirection initialDirection) {
        this.direction = initialDirection;
        this.position = initialPosition;
    }
    public Animal() {
        this.direction = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    public String toString() {
            return ": " + this.position.toString() + ", kierunek: " + this.direction.toString();
        }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }


    public void move(MoveDirection direction){
        switch (direction) {
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
                if (newPosition.precedes(new Vector2d(4,4)) && newPosition.follows(new Vector2d(0,0))) {
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                if (newPosition.precedes(new Vector2d(4,4)) && newPosition.follows(new Vector2d(0,0))) {
                    this.position = newPosition;
                }
            }
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
        }
    }
    public MapDirection getDirection() {
        return this.direction;
    }
}
