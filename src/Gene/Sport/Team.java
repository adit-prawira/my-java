package Gene.Sport;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{
    private String name;
    private ArrayList<T> members = new ArrayList<>();
    int gamePlayed = 0;
    int won =0;
    int lost = 0;
    int tied = 0;
    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName()+ " is already on the team");
            return false;
        }else{
            members.add(player);
            System.out.println(player.getName() + " is picked for team " + this.name);
            return true;
        }
    }
    public int numPlayers(){return this.members.size();}

    // Only accept opponent of the same type team;
    public void matchResult(Team<T> opponent, int ourScore, int opponentScore){
        String message;
        if(ourScore > opponentScore){
            won ++;
            message = " beat ";
        }else if (ourScore == opponentScore){
            tied++;
            message = " drew with ";
        }else{
            lost++;
            message = " lost to ";
        }
        gamePlayed++;
        if(opponent != null){
            // Call matchResult of the opponent and update their game status by inserting
            // their score and compare it with our score
            // In this case ourScore is opponentScore
            // and ourScore is opponentScore
            System.out.println(this.getName()+ message + opponent.getName());
            opponent.matchResult(null, opponentScore, ourScore);

        }
    }

    // one simple formula to calculate ranking
    public int ranking(){return (won*2) + tied;}

    @Override
    public int compareTo(Team<T> team) {
        //if(this.ranking() > team.ranking()){return -1;
        //}else if (this.ranking() < team.ranking()){return 1;
        //}else{ return 0;}
        // Can be replaced as below
        return Integer.compare(team.ranking(), this.ranking());
    }
}
