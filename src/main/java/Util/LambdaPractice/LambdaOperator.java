package main.java.Util.LambdaPractice;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.Arrays;

interface PerformOperations {
    boolean check(int a);

}

public class LambdaOperator {
    public static boolean checker(PerformOperations op, int a) {
        Integer[] temp = new Integer[100];
        Function<Integer, Integer> aFunction = (x) -> x + 10;
        Stream.of(temp).forEach(n -> aFunction.apply(n));

        Arrays.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return op.check(a);
    }

    public PerformOperations isOdd() {
        return (a -> a % 2 != 0);
    }
}