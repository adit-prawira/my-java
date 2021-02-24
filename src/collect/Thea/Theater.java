package collect.Thea;

import java.util.*;

public class Theater {
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();
    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0;
                }

            }
        };
    }

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        int lastRow = 'A' + (numRows - 1); // will return character's int value, in this case Z
        for(char row = 'A'; row <= lastRow; row++){
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                double price = 12.00;
                if((row < 'D') && (seatNum >= 4 && seatNum <= 9)){
                    price = 14.00;
                }else if((row > 'F') || (seatNum < 4 || seatNum > 9)){
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }
    // Binary Search
    public boolean reservedSeatBS(String seatNumber) {
        int low = 0;
        int high = seats.size() - 1;
        while (low <= high) {
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int comparison = midVal.getSeatNumber().compareTo(seatNumber);
            if (comparison < 0) {
                low = mid + 1;
            } else if (comparison > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;

    }
    public boolean reservedSeatCBS(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber,0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if(foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        }else{
            System.out.println("There is no seat "+ seatNumber);
            return false;
        }
    }


    // For testing
    public Collection<Seat> getSeats(){
        return seats;
    }

    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;
        private double price;
        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }
        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " is reserved");
                return true;
            }else{
                return false;
            }
        }
        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber+ " is cancelled");
                return true;
            }else{
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
