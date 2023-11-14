package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.List;
import java.util.Set;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");

        GrassField map2 = new GrassField(10);
        List<MoveDirection> directions2 = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        List<Vector2d> positions2 = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation2 = new Simulation(directions2, positions2, map2);
        simulation2.run();
        Set<WorldElement> elements = map2.getElements();
        System.out.println(elements);
        int count = 0;
        for (WorldElement s : elements) {
            if (s.toString().equals("*")) {
                count++;
            }
        }
        System.out.println(count);

        System.out.println("Stop");
    }
}