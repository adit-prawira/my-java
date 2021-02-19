package collect.Thea;

public class MainTheater {
    public static void main(String[] args){
        Theater theater = new Theater("Olympian", 8, 12);

        if(theater.reservedSeat("H11")){
            System.out.println("Please pay");
        }else{
            System.out.println("Sorry the seat is taken");
        }
        if(theater.reservedSeat("H11")){
            System.out.println("Please pay");
        }else{
            System.out.println("Sorry the seat is taken");
        }
    }
}
