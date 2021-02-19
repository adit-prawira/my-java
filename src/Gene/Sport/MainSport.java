package Gene.Sport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainSport {
    public static void main(String[] args){
        /*
        * ArrayList<Team> teams;
        * Collections.sort(teams);
        * Create a generic class to implement a league table for a sport.
        * The class should allows teams to be added to the list, and store
        * a list of teams that belong to the game.
        *
        * Your class should have a method to p[rint out the teams in order,
        * with the team at the top of th league printed first.
        *
        * Only teams of the same type should be added to any particular
        * instance of the league class -the program should fail to compile
        * if an attempt is made to add an incompatible team.
        */

//        FootballPlayer adam = new FootballPlayer("Adam");
//        BaseballPlayer joey = new BaseballPlayer("Joey");
//        SoccerPlayer paul = new SoccerPlayer("Paul");
//
//        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
//        baseballTeam.addPlayer(joey);
//        System.out.println(baseballTeam.numPlayers());
//
//        Team<SoccerPlayer> soccerPlayerTeam = new Team<>("LA Galaxy");
//        soccerPlayerTeam.addPlayer(paul);
//        System.out.println(soccerPlayerTeam.numPlayers());
//
//        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
//        adelaideCrows.addPlayer(adam);
//        System.out.println(adelaideCrows.numPlayers());
        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");
        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");

        footballLeague.addTeam(adelaideCrows);
        footballLeague.addTeam(melbourne);
        footballLeague.addTeam(hawthorn);
        footballLeague.addTeam(fremantle);

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);
        adelaideCrows.matchResult(fremantle, 2, 1);
        adelaideCrows.matchResult(hawthorn, 1, 1);
        footballLeague.showLeague();
//        System.out.println("Rankings");
//        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
//        System.out.println(melbourne.getName() + ": " + melbourne.ranking());
//        System.out.println(fremantle.getName() + ": " + fremantle.ranking());
//        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());
//        System.out.println(adelaideCrows.compareTo(melbourne));
//        System.out.println(adelaideCrows.compareTo(hawthorn));
//        System.out.println(hawthorn.compareTo(adelaideCrows));
//        System.out.println(melbourne.compareTo(fremantle));
    }
}
