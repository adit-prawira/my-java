package InterAbs.Game;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISavable {
    private String name;
    private int hitPoints;
    private int strength;
    public Monster(String name, int hitPoints, int strength){
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength =strength;
    }
    // Monster Class Setters
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Monster Class Getters
    public int getStrength() {
        return strength;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public String getName() {
        return name;
    }


    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, ""+ this.hitPoints);
        values.add(2, ""+ this.strength);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() > 0){
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
        }
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}
