package main.java.Processor.medium;

import java.util.HashMap;
import java.util.Map;

public class ProductOfArrayExceptSelf238 {

    public int[] productExceptSelf(int[] nums) {
        Map<Integer, Integer> powerMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            var mul = 1;
            if (powerMap.containsKey(nums[i])) {
                mul = powerMap.get(nums[i]) * nums[i];
            }
            powerMap.put(nums[i], mul);
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int total = 1;
            for (Map.Entry<Integer, Integer> entry : powerMap.entrySet()) {
                if (entry.getKey() != nums[i]) {
                    total *= entry.getValue() * entry.getKey();
                } else {
                    total *= entry.getValue();
                }
            }
            result[i] = total;
        }
        return result;
    }

}
