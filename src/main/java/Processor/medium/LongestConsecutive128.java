package src.main.java.Processor.medium;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(var i : nums) {
            counter.put(i, 1);
        }
        int max = 0;
        for(var i : nums) {
            int count = 1;
            Integer key = i+1;
            while (counter.containsKey(key)) {
                count++;
                counter.remove(key);
                key++;
            }
            key = i-1;
            while (counter.containsKey(key)) {
                count++;
                counter.remove(key);
                key--;
            }
            max = Math.max(max, count);
            Queue<int[] > queue = new LinkedList<>();
        }

        return max;
    }
    public static void main(String[] args) {

    }
}
