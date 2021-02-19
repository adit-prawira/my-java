package Gene.Sport;

import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team> {
    private String name;
    private ArrayList<T> league = new ArrayList<>();
    public League(String name) {
        this.name = name;
    }

    public boolean addTeam(T team){
        if(league.contains(team)){
            System.out.println(team.getName() + " is already in this league");
            return false;
        }else{
            System.out.println(team.getName() + "is added to " + this.name + " league");
            league.add(team);
            return true;
        }
    }
    public void showLeague(){
        Collections.sort(league);
        for(T t: league){
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
