package InterAbs.Zoo;

public abstract class Bird extends Animal implements CanFly{
    public Bird(String name){
        super(name);
    }
    @Override
    public void eat() {
        System.out.println(getName() + " is eating corn");
    }

    @Override
    public void breath() {
        System.out.println(getName() + " is breathing with small lungs");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flapping its wings");
    }
}
