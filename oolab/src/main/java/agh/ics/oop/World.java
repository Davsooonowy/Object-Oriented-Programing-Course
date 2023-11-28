package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class World {
    public static void main(String[] args) {
        try {
            System.out.println("Start");
            List<MoveDirection> directions2 = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f"});
            List<Vector2d> positions2 = List.of(new Vector2d(2, 2), new Vector2d(3, 2));

            List<MoveDirection> directions3 = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f"});
            List<Vector2d> positions3 = List.of(new Vector2d(2, 2), new Vector2d(3, 2));

            ArrayList<Simulation> simulations = new ArrayList<>();

            for(int i =0; i < 2137; i++) {
                AbstractWorldMap map = new RectangularMap(10, 10);
                AbstractWorldMap map1 = new GrassField(10);
                map.addMapChangeListener(new ConsoleMapDisplay());
                map1.addMapChangeListener(new ConsoleMapDisplay());
                simulations.add(new Simulation(directions2, positions2, map));
                simulations.add(new Simulation(directions3, positions3, map1));
            }

            SimulationEngine engine = new SimulationEngine(simulations);
            engine.runAsyncInThreadPool();
            try {
                engine.awaitSimulationsEnd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Stop");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}