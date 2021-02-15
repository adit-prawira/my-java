package InterAbs.Engine;

public class MainEngine {
    public static void main(String[] args){
        GearBox mcLaren = new GearBox(6);

        // Creating Gear instance which is the inner class of GearBox.
        // Hence, need to reference the outer class first.
        GearBox.Gear first = mcLaren.addGear(1, 12.3);
        System.out.println(first.driveSpeed(1000));
    }
}
