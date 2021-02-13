package InterAbs.StorageSaving;

import java.util.ArrayList;
import java.util.Scanner;

public class MainStorage {
    public static void main(String[] args){
        /*
        * 1. Create a simple interface (Saveable or ISaveable)
        * 2. The interface allows an object to be saved to some sort of storage medium. (use ArrayList)
        * 3. Th exact type of medium is not known to the interface (nor to the classes that impleemnt it)
        * 4. The interface will specify two methods, one to return an ArrayList of values to be saved
        *    and the other to populate the object's fields from an ArayList (paramter)
        * 5. Create a few sample classes that implement tyou Saveable interface
        * 6. Override the toString() method for each of you classes so that they can be easily printed to
        *    enable the program to be tested easier
        * 7. In main program, write a method that makes an obejct that implemenets the interface as a
        *    parameter and "saves" the values e.g. calls the method defined int he interface
        * 8. */

    }

    public static ArrayList<String> readValues(){
        ArrayList<String> values  = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        boolean quit =false;
        int index = 0;
        System.out.println("Choose:");
        System.out.println("1 - To enter a string");
        System.out.println("0 - To quit the program");

        while(!quit){
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}
