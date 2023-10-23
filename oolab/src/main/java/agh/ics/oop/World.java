package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MapDirection;

public class World {

    public static void run(MoveDirection[] directions) {
        for (MoveDirection direction: directions){
            switch (direction) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
            }
        }

    }
    public static void main(String[] args) {
//        System.out.println("Start");
//        MoveDirection[] directions = OptionsParser.parse(args);
//        run(directions);
//        System.out.println("Stop");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection direction = MapDirection.EAST;
        System.out.println(direction);  // Wschód
        System.out.println(direction.next());  // Południe
        System.out.println(direction.previous());  // Północ

        Vector2d unitVector = direction.toUnitVector();
        System.out.println(unitVector);  // (1,0)
    }

}
