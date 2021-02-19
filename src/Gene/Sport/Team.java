package Gene.Sport;

import java.util.ArrayList;

public class Team {
    private String name;
    int gamePlayed = 0;
    int won =0;
    int lost = 0;
    int tied = 0;
    private ArrayList<Player> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(Player player){
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
    public void matchResult(Team opponent, int ourScore, int opponentScore){
        if(ourScore > opponentScore){
            won ++;
        }else if (ourScore == opponentScore){
            tied++;
        }else{
            lost++;
        }
        gamePlayed++;
        if(opponent != null){
            // Call matchResult of the opponent and update their game status by inserting
            // their score and compare it with our score
            // In this case ourScore is opponentScore
            // and ourScore is opponentScore
            opponent.matchResult(null, opponentScore, ourScore);
        }
    }

    // one simple formula to calculate ranking
    public int ranking(){return (won*2) + tied;}
}
