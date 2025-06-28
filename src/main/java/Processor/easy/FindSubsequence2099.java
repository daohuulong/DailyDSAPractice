package src.main.java.Processor.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindSubsequence2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        return IntStream.range(0, nums.length)
                .mapToObj(i -> new int[]{nums[i], i})
                .sorted((a, b) -> b[0] - a[0])
                .limit(k)
                .mapToInt(a -> a[1])
                .sorted()
                .map(a -> nums[a])
                .toArray();
    }
}
