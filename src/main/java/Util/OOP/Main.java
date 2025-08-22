package src.main.java.Util.OOP;

public class Main {

    public static void main(String[] agrs) {
        FourLegsMovingStrategy fourLegsMovingStrategy = new FourLegsMovingStrategy();
        TwoLegsMovingStrategy twoLegsMovingStrategy = new TwoLegsMovingStrategy();
        Dog dog = new Dog(twoLegsMovingStrategy);
        Cat cat = new Cat(fourLegsMovingStrategy);

        dog.move(4);
        cat.move(10);
    }
}
