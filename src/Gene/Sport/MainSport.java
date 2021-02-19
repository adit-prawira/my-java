package Gene.Sport;

public class MainSport {
    public static void main(String[] args){
        FootballPlayer adam = new FootballPlayer("Adam");
        BaseballPlayer joey = new BaseballPlayer("Joey");
        SoccerPlayer paul = new SoccerPlayer("Paul");

        Team adelaideCrows = new Team("Adelaide Crows");
        adelaideCrows.addPlayer(adam);
        adelaideCrows.addPlayer(joey);
        adelaideCrows.addPlayer(paul);
        System.out.println(adelaideCrows.numPlayers());


    }
}
