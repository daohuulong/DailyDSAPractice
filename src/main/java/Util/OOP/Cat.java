package src.main.java.Util.OOP;

public class Cat extends Animals {
    IMoving movingStrategy;

    public Cat(IMoving movingStrategy) {
        this.movingStrategy =  movingStrategy;
    }

    @Override
    public void move(int step) {
        System.out.println("Cat moving: ");
        movingStrategy.walk(step);
    }
}
