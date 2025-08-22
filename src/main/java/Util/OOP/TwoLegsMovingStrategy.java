package src.main.java.Util.OOP;

public class TwoLegsMovingStrategy implements IMoving{
    @Override
    public void walk(int step) {
        System.out.println("TwoLegsMovingStrategy step: " + step);
    }
}
