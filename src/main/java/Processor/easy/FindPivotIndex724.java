package src.main.java.Processor.easy;

public class FindPivotIndex724 {
    public int pivotIndex(int[] nums) {
        var total = 0;
        var index = -1;
        for (int num : nums) total += num;
        var sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == total - sum - nums[i]) {
                index = i;
                break;
            }
        }
        return index;

    }

}

