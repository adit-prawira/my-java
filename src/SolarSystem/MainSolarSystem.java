package SolarSystem;

import collect.Thea.Theater;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainSolarSystem   {
    private static Map<String, HeavenlyBody> solarSystems = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        // Solar System
        // Has groups of Planets, Asteroids, Comets, Moons
        // Some moons might belong to another group

        // Mercury
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystems.put(temp.getName(), temp);
        planets.add(temp);

        // Venus
        temp = new HeavenlyBody("Venus", 225);
        solarSystems.put(temp.getName(), temp);
        planets.add(temp);

        // Earth
        temp = new HeavenlyBody("Earth", 365);
        solarSystems.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystems.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // Add moon to temp which is current earth

        // Mars
        temp = new HeavenlyBody("Mars", 687);
        solarSystems.put(temp.getName(), temp);
        planets.add(temp);
        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystems.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystems.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        // Jupiter
        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystems.put(temp.getName(), temp);
        planets.add(temp);
        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystems.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystems.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystems.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystems.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        // Saturn
        temp = new HeavenlyBody("Saturn", 10759);
        solarSystems.put(temp.getName(), temp);
        planets.add(temp);

        // Uranus
        temp = new HeavenlyBody("Uranus", 30660);
        solarSystems.put(temp.getName(), temp);
        planets.add(temp);

        // Neptune
        temp = new HeavenlyBody("Neptune", 165);
        solarSystems.put(temp.getName(), temp);
        planets.add(temp);

        // Pluto
        temp= new HeavenlyBody("Pluto", 248);
        solarSystems.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets:");
        for(HeavenlyBody planet: planets){
            System.out.println("\t- " + planet.getName());
        }
        HeavenlyBody body = solarSystems.get("Mars");
        System.out.println("Moons of " + body.getName()+ ":");
        for(HeavenlyBody satellite: body.getSatellites()){
            System.out.println("\t- " + satellite.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet: planets){
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons:");
        for(HeavenlyBody moon: moons){
            System.out.println("\t- "+ moon.getName());
        }
        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto);

        for(HeavenlyBody planet: planets){
            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
        }
        Object o = new Object();
        o.equals(o);
        "pluto".equals("");
    }
}
