package InterAbs.Zoo;

public class Penguin extends Bird{
    public Penguin(String name){
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Can't fly, but can swim");
    }
}
