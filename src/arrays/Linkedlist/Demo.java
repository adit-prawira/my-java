package arrays.Linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

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
}
