package src.main.java.Util.OOP;

public class FourLegsMovingStrategy implements IMoving{
    @Override
    public void walk(int step) {
        System.out.println("FourLegsMovingStrategy step: " + step);
    }
}
