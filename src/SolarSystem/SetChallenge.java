package SolarSystem;

public class SetChallenge {
    public static void main(String[] args) {
        /*
        * Modify HeavenlyBody class so that the class has a "bodyType" field. This field will store the type of
        * HeavenlyBody class (such as STAR, PLANET, MOON, etc).
        *
        * Subclass the HeavenlyBody class so that the program can create objects of the appropriate type.
        *
        * Although astronomers may a shudder at this, the model solar system will allow two bodies to have the same
        * name as long as they are not the same type of body; so a start could be called as "BetaMinor" and an asteroid
        * could be called "BetaMinor
        *
        * --> Implement for the Set than it is for the map because the Map will need a key that uses both fields.
        *
        * There is a restriction that the only satellites that planets can have must be moons. Even if you don't
        * implement a START type, though, your program should not prevent one being added int he future (and a STAR's
        * satellites can be almost every kind of HeavenlyBody)
        *
        * Test Cases:
        * 1. The planets and moons that we added should appear in the solarSystem collection and in the sets of moons
        * for the appropriate planets
        * 2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.
        * 3. Attempting to add a duplicate to a Set must result in no change to the set (so the original value is not
        * replaced byt he new one).
        * 4. Attempting to add a duplicate to a Map may results in the original being replaced by the new object.
        * 5. Two bodies with the same name but different designations can be added to the same set.
        * 6. Two bodies with the same name but different designations can be added to the same map, and can be
        * retrieved from the map.
         * */
    }
}
