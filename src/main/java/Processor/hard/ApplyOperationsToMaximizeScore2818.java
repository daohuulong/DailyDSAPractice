package Processor.hard;

import java.util.*;

/**
 * 1. calculate the prime score of each store in primes
 * 2. sort the array desc and keep memorized base index in the new array: M
 * 3. when count < k:
 * 3.1. chose element Y in and multiply with x, increase count
 * 3.2. keep the index of nums (idx), loop while (idx < nums.length && primes[nums[idx]] <= primes[Y]):
 * each chosen we multiply Y with x and increase count
 * 3.2. keep the index of nums (idx), loop while (idx >= 0 &&  primes[nums[idx]] <= primes[Y])
 * eacg chosend we multiply Y with x and increse count
 */

public class ApplyOperationsToMaximizeScore2818 {
    private static final int MODULAR = 1_000_000_007;
    long timePower = 0L;
    private static class NumWithIndex implements Comparable<NumWithIndex> {
        int val;
        int idx;

        public NumWithIndex(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(NumWithIndex other) {
            if (other.val != this.val)
                return other.val - this.val;
            return this.idx - other.idx;
        }
    }

    public int maximumScore(List<Integer> nums, int k) {
        long now = System.currentTimeMillis();
        var n = nums.size();
        int[] primeScore = new int[nums.size()];
        Queue<NumWithIndex> numsIndex = new PriorityQueue<>();
        for (int i = 0; i < nums.size(); i++) {
            numsIndex.add(new NumWithIndex(nums.get(i), i));
        }
        System.out.println("sort = " + (System.currentTimeMillis() - now));
        now = System.currentTimeMillis();
        for (int i = 0; i < nums.size(); i++)
            primeScore[i] = primeScore(nums.get(i));
        System.out.println("prime = " + (System.currentTimeMillis() - now));
        now = System.currentTimeMillis();

        int[] monotonicIncreasing = genMonotonicIncreasing(primeScore);
        int[] monotonicDecreasing = genMonotonicDecreasing(primeScore);
        System.out.println("monotonic = " + (System.currentTimeMillis() - now));
        now = System.currentTimeMillis();

        long rs = 1L;
        while (k > 0 && !numsIndex.isEmpty()) {
            var crrItem = numsIndex.poll();
            if (null == crrItem)
                break;
            int crr = crrItem.val;
            if (crr == 1)
                break;
            int idx = crrItem.idx;
            long countLeft = monotonicDecreasing[idx] == -1 ? idx + 1 : idx - monotonicDecreasing[idx];
            long countRight = monotonicIncreasing[idx] == -1 ? n - idx : monotonicIncreasing[idx] - idx;

            long remain = Math.min(k, countLeft * countRight);
            k -= remain;
            rs = (rs * power(crr, remain)) % MODULAR;
        }
        System.out.println("rs = " + (System.currentTimeMillis() - now));
        System.out.println("timePower = " + timePower);

        return (int) rs;
    }

    private int[] genMonotonicDecreasing(int[] primeScore) {
        int[] result = new int[primeScore.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < primeScore.length; i++) {
            while (!stack.isEmpty() && primeScore[i] > primeScore[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.push(i);
        }

        return result;
    }

    private int[] genMonotonicIncreasing(int[] primeScore) {
        int[] result = new int[primeScore.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < primeScore.length; i++) {
            while (!stack.isEmpty() && primeScore[i] > primeScore[stack.peek()]) {
                result[stack.pop()] = i;
            }
            stack.push(i);
        }

        return result;
    }

    private int primeScore(int num) {
        if (num == 1)
            return 0;
        Set<Integer> score = new HashSet<>();
        int i = 2;
        while (i < Math.sqrt(num)) {
            while (num % i == 0) {
                num /= i;
                score.add(i);
            }
            i++;
        }
        int delta = 0;
        if (num >= 2) {
            delta = 1;
        }
        return score.size() + delta;
    }

    private long power(long num, long pow) {
        if (num == 1 || pow == 0)
            return 1;
        long start = System.currentTimeMillis();
        long rs = 1L;

        while (pow > 0) {
            if (pow % 2 == 1) {
                rs = (rs * num) % MODULAR;
            }
            num = (num * num) % MODULAR;
            pow /= 2;
        }

        timePower += System.currentTimeMillis()-start;
        return rs % MODULAR;
    }
}
