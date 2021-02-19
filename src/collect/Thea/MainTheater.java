package collect.Thea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTheater {
    public static void main(String[] args){
        Theater theater = new Theater("Olympian", 8, 12);
        if(theater.reservedSeatCBS("A02")){
            System.out.println("Please pay for A02");
        }else{
            System.out.println("Seat is already reserved");
        }
        if(theater.reservedSeatCBS("B13")){
            System.out.println("Please pay for B13");
        }else{
            System.out.println("Seat is already reserved");
        }
        if(theater.reservedSeatCBS("A02")){
            System.out.println("Please pay for A02");
        }else{
            System.out.println("Seat is already reserved");
        }
        List<Theater.Seat> reservedSeats = new ArrayList<>(theater.getSeats());
        Collections.reverse(reservedSeats);
        printList(reservedSeats);

        List<Theater.Seat> priceSeats = new ArrayList<>(theater.getSeats());
        priceSeats.add(theater.new Seat("B00", 13.00));
        priceSeats.add(theater.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theater.PRICE_ORDER);
        printList(priceSeats);

    }
    public static void printList(List<Theater.Seat> list){
        for(Theater.Seat seat: list){
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice() );
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
