package Adventure;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;
    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>(exits);

        // Automatically added quit key for each location
        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }
    public String getDescription() {
        return description;
    }

    // This technique is useful because nothing outside of Location class can change exit
    // the getter will return the copy of exits so if the calling program wants to add or remove mappings from it
    // and the exits mapping filed won't be affected.
    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }

//    public void addExit(String direction , int location){
//        exits.put(direction, location);
//    }


}
