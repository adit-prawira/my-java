package Gene.Sport;

public class MainSport {
    public static void main(String[] args){
        FootballPlayer adam = new FootballPlayer("Adam");
        BaseballPlayer joey = new BaseballPlayer("Joey");
        SoccerPlayer paul = new SoccerPlayer("Paul");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(adam);
        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(joey);
        System.out.println(baseballTeam.numPlayers());

        Team<SoccerPlayer> soccerPlayerTeam = new Team<>("LA Galaxy");
        soccerPlayerTeam.addPlayer(paul);
        System.out.println(soccerPlayerTeam.numPlayers());

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");
        FootballPlayer banks = new FootballPlayer("Gordon");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);
        adelaideCrows.matchResult(hawthorn, 1, 1);
    }
}
