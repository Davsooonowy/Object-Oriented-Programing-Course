package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationTest {
    @Test

    void test(){
        List<MoveDirection> directions1 = OptionsParser.parse(new String[]{"f", "f", "r", "l"});
        List<Vector2d> positions1 = List.of(new Vector2d(1,2), new Vector2d(4,4));
        Simulation simulation1 = new Simulation(directions1, positions1);
        simulation1.run();
        assertEquals(simulation1.getAnimal(0).toString(),": (1,3), kierunek: Wschód");
        assertEquals(simulation1.getAnimal(1).toString(),": (4,4), kierunek: Zachód");

        List<MoveDirection> directions2 = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        List<Vector2d> positions2 = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation2 = new Simulation(directions2, positions2);
        simulation2.run();
        assertEquals(simulation2.getAnimal(0).toString(),": (3,0), kierunek: Południe");
        assertEquals(simulation2.getAnimal(1).toString(),": (2,4), kierunek: Północ");

        List<MoveDirection> directions3 = OptionsParser.parse(new String[]{"f", "f", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        List<Vector2d> positions3 = List.of(new Vector2d(0,4), new Vector2d(1,2), new Vector2d(1,1));
        Simulation simulation3 = new Simulation(directions3, positions3);
        simulation3.run();
        assertEquals(simulation3.getAnimal(0).toString(),": (0,4), kierunek: Północ");
        assertEquals(simulation3.getAnimal(1).toString(),": (3,4), kierunek: Wschód");
        assertEquals(simulation3.getAnimal(2).toString(),": (4,1), kierunek: Wschód");

        List<MoveDirection> directions4 = OptionsParser.parse(new String[]{
                "f", "r", "b", "b, r, l", "b", "r", "l", "f", "r", "f", "f", "f", "r", "r", "r", "f", "f", "fy", "l", "apple", "b", "b",
                "b", "b", "b", "l", "r0", "r", "b", "l", "a g h", "l", "l, r", "l", "l", "l", "r", "l", "r", "l", "f", "f", "b", "b", "f",
                "f", "f5", "b", "f", "b", "f", "f", "f","agh", "l2", "f", "f", "r", "f r l", "f", "l",
                "f", "f", "r", "l", "wydział informatyki", "r", "b", "pear", "l", "f", "f", "a g h", "fgh", "f", "l", "dog", "r", "b",
                "cat", "f", "l", "r,b,b,b,l,b,l,bl", "bb", "b", "ff", "b", "f", "rrr", "f", "f", "r", "l", "ba ba b", "r", "l",
                "f", "f", "r", "wi", "f", "b", "l", "r", "r, r, r", "f", "r", "l", "pineapple", "b", "b", "b", "l",
                "l", "l,b", "lubelskie", "apple", "f", "f", "r", "l", "b", "f", "f", "r", "l", "f", "f", "b", "b", "f",
                "krakow", "f", "l", "l", "f", "r", "r", "r", "f", "r", "f", "biłgoraj", "f", "l", "forward", "backward", "agh", "f, r", "f", "r, r ,r", "l", "f", "f", "f", "f", "f", "f", "f", "f", "f", "f"});
        List<Vector2d> positions4 = List.of(new Vector2d(1,4), new Vector2d(0,2), new Vector2d(4,3), new Vector2d(4,4), new Vector2d(0,0), new Vector2d(2,2), new Vector2d(3,1), new Vector2d(1,3));
        Simulation simulation4 = new Simulation(directions4, positions4);
        simulation4.run();
        assertEquals(simulation4.getAnimal(0).toString(),": (1,1), kierunek: Zachód");
        assertEquals(simulation4.getAnimal(1).toString(),": (0,0), kierunek: Południe");
        assertEquals(simulation4.getAnimal(2).toString(),": (2,2), kierunek: Zachód");
        assertEquals(simulation4.getAnimal(3).toString(),": (4,4), kierunek: Północ");
        assertEquals(simulation4.getAnimal(4).toString(),": (4,0), kierunek: Południe");
        assertEquals(simulation4.getAnimal(5).toString(),": (1,0), kierunek: Zachód");
        assertEquals(simulation4.getAnimal(6).toString(),": (4,1), kierunek: Wschód");
        assertEquals(simulation4.getAnimal(7).toString(),": (0,4), kierunek: Zachód");

        List<MoveDirection> directions5 = OptionsParser.parse(new String[]{"f", "r", "b", "b", "r", "l", "f", "r", "f", "f", "f", "r", "r", "r", "f", "f", "f", "l", "b", "b", "b", "b", "b", "l", "r", "r",
                                                                           "b", "l", "l", "l", "l", "l", "r", "l", "r", "l", "f", "f", "b", "b", "f", "f", "f", "b", "f", "b", "f", "f", "f", "l", "f", "f",
                                                                           "r", "r", "f"});
        List<Vector2d> positions5 = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(4,3), new Vector2d(2,2), new Vector2d(0,0));
        Simulation simulation5 = new Simulation(directions5, positions5);
        simulation5.run();
        assertEquals(simulation5.getAnimal(0).toString(),": (1,2), kierunek: Południe");
        assertEquals(simulation5.getAnimal(1).toString(),": (4,4), kierunek: Wschód");
        assertEquals(simulation5.getAnimal(2).toString(),": (4,2), kierunek: Południe");
        assertEquals(simulation5.getAnimal(3).toString(),": (1,3), kierunek: Zachód");
        assertEquals(simulation5.getAnimal(4).toString(),": (2,0), kierunek: Wschód");
    }
}
