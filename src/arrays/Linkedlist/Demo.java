package arrays.Linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");

        printList(placesToVisit);

        addInOrder(placesToVisit, "Alice Springs");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);
        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i =linkedList.iterator();
        // Remainder: .hasNext() check if the current entry has the next entry
        while(i.hasNext()){
            // Remainder: .next() will return the current entry and
            // automatically moves to the next entry
            System.out.println("Now visiting "+ i.next());
        }
        System.out.println("===============================");
    }

    // Sort LinkedList in alphabetical order while preventing duplication
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();

        // Remainder: .hasNext() check if the current entry has the next entry
        while(stringListIterator.hasNext()){
            // Remainder: .next() will return the current entry and
            // automatically moves to the next entry
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0){
                // Equal, do not add. Hence, prevent duplication
                System.out.println(newCity + " is already included as a destination");
                return false;
            }
            if(comparison > 0){
                // newCity should appear before this one
                // Example:
                // Currently looking at the record of Brisbane => Adeliade passes as parameter.
                // Adelaide alphabetically starts before Brisbane (A comes before B)
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }

        }
        // move on to the next city
        // since comparison > 0 which indicates that the newCity is alphabetically in order.
        stringListIterator.add(newCity);
        return true;
    }


    private static void visit(LinkedList<String> cities){
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        // Expect the very first entry in the link which is empty or "" for String type
        if(cities.isEmpty()){
            System.out.println("No cities in the iternary");
            return;
        }else{
            System.out.println("Now visiting "+ listIterator.next());
            printMenu();
        }
        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visiting " + listIterator.next());
                    }else{
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visiting " + listIterator.previous());
                    }else{
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("0 - To quit");
        System.out.println("1 - Go to next city");
        System.out.println("2 - Go to previous city");
        System.out.println("3 - Show menu options");
    }
}
