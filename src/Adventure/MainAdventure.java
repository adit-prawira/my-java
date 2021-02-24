package Adventure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainAdventure {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    public static void main(String[] args) {
        /*
        * Change the program to allow players to type full words, or phrases, then move to the
        * correct location based upton their input.
        * The player should be able to type commands such as "Go West", "run South", or just "East"
        * and the program will move to the appropriate location if there is one. As at present, an
        * attempt to move in an invalid direction should print message and remain in the same place
        *
        * Single letter commands (N, W, S, E, Q) should still be available
        */
        Scanner scanner = new Scanner(System.in);
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        // Reminder: Map<String, Integer> exits
        // ROAD
        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
        // HILL
        locations.get(2).addExit("N", 5);
        // Building
        locations.get(3).addExit("W", 1);
        // Valley
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        // Forest
        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("NORTH", "N");


        int loc = 1;
        while(true){
            // locations.get(loc) is Location type
            System.out.println(locations.get(loc).getDescription());
            if(loc ==0){
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exist are ");
            for(String exit: exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1){
                String[] words = direction.split(" ");
                for(String word: words){
                    if(vocabulary.containsKey(word)){
                        // In this case direction = "Q" || "S" || "W" || "E" || "N"
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            }else{
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
