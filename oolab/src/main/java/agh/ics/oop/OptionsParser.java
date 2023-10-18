package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class OptionsParser {

    public static MoveDirection[] parse(String[] args) {
        int size = 0;
        for(String arg: args) {
            if( arg.equals("f") || arg.equals("b") || arg.equals("l") || arg.equals("r")){
                size++;
            }
        }
        MoveDirection[] directions = new MoveDirection[size];
        int i = 0;

        for( String arg: args ){
            switch (arg){
                case "f":
                    directions[i] = MoveDirection.FORWARD;
                    i++;
                    break;
                case "b":
                    directions[i] = MoveDirection.BACKWARD;
                    i++;
                    break;
                case "l":
                    directions[i] = MoveDirection.LEFT;
                    i++;
                    break;
                case "r":
                    directions[i] = MoveDirection.RIGHT;
                    i++;
                    break;
                default:
                    break;
            }
        }

        return directions;
    }
}
