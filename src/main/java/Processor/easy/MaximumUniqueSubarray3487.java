package src.main.java.Processor.easy;

import java.util.*;

public class MaximumUniqueSubarray3487 {
    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(var i :nums) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        if (max < 0) {
            return max;
        }
        List<Integer> t = new ArrayList<>();
        int n = nums.length;
        int rs = min;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> counterMap = new HashMap<>();
            int sum = nums[i];
            counterMap.put(nums[i], 1);
            for (int j = i+1; j < n; j++) {
                if(!counterMap.containsKey(nums[j])
                        && sum + nums[j] > sum) {
                    sum += nums[j];
                    counterMap.put(nums[j],1);
                }
            }
            rs = Math.max(rs, sum);
        }
        return rs;

    }
}
