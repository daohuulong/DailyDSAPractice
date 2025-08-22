package src.main.java.Util.OOP;

import javax.print.Doc;

public class Dog extends Animals {
    IMoving moving;

    public Dog(IMoving moving) {
        this.moving = moving;
    }
    @Override
    public void move(int step) {
        System.out.println("Dog moving: ");
        this.moving.walk(step);
    }
}
