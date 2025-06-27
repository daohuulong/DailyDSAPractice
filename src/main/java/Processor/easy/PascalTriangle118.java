package Processor.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        pascal.add((new ArrayList<Integer>()));
        for(int i=1; i< numRows; i++) {
            List<Integer> rowi = new ArrayList<>();
            rowi.add(1);
            for(int j=1; j<i-1;j++) {
                var left = pascal.get(i-1).get(j-1);
                var right = pascal.get(i-1).get(j);

                rowi.add(left+right);
            }
            rowi.add(1);
            pascal.add(rowi);
        }
        return pascal;
    }
}
