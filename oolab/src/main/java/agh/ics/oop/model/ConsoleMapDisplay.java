package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {
    private int changescnt;

    public ConsoleMapDisplay() {
        this.changescnt = 0;
    }
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        changescnt++;
        System.out.println(message);
        System.out.println("Number of changes: " + changescnt);
        System.out.println(worldMap.toString());
    }
}