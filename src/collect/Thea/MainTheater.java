package collect.Thea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTheater {
    public static void main(String[] args){
        Theater theater = new Theater("Olympian", 8, 12);
        // shallow copy
        List<Theater.Seat> seatCopy = new ArrayList<>(theater.seats);
        printList(seatCopy);
        seatCopy.get(1).reserve();
        if(theater.reservedSeatBS("A02")){
            System.out.println("Please pay");
        }else{
            System.out.println("Seat is already reserved");
        }

        Collections.reverse(seatCopy);
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theater.seat");
        printList(theater.seats);

        Theater.Seat minSeat = Collections.min(seatCopy);
        Theater.Seat maxSeat = Collections.max(seatCopy);
        System.out.println(" Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is "+ maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);
    }
    public static void printList(List<Theater.Seat> list){
        for(Theater.Seat seat: list){
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("========================================================================================");
    }
    // Bubble sort
    // Merge sort require far more memory than bubble sort
    // Takes any type of List of Theater.Seat as long it implements Comparable interface
    public static void sortList(List<? extends Theater.Seat> list){
        for(int i = 0; i< list.size() - 1; i++){
            for(int j = i+1; j< list.size(); j++){
                if(list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list, i, j);
                }
            }
        }

    }


}
