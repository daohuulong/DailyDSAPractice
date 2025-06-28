package src.main.java.Processor.hard;

import java.util.*;

public class IdealArrays2338 {
    private static int MOD = 1_000_000_007;

    public int idealArrays(int n, int maxValue) {
        var res1 = useCount(n, maxValue);
        var res2 = useDP(n, maxValue);
        return res2;
    }

    private static int[] primes100 = new int[]{2, 3, 4, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
            67, 71, 73, 79, 83, 89, 97};
    private Map<Integer, Set<Integer>> primeFactorMap = new HashMap<>();

    private int useCount(int n, int num) {
        int res = 1;
        for (int i = 2; i <= num; i++) {
            var factor = getFactor(i);

            int s = (n);
            for (Integer j : factor) {
                s = (s + sum(n - 1, j)) % MOD;
            }
            res = (res + s) % MOD;
        }
        return res;
    }


    public int sum(int n, int num) {
        var factor = getFactor(num);
        int res = ((n) * (n + 1) / 2) % MOD;
        for (int f : factor) {
            if (isPrime(f)) {
                res = (res + (n * (n * n - 1) / 6)) % MOD;
            } else
                res = (res + (sum(n - 1, f))) % MOD;
        }
        return res;
    }

    private Set<Integer> getFactor(int num) {
        if (primeFactorMap.containsKey(num))
            return primeFactorMap.get(num);
        Set<Integer> res = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while (!q.isEmpty()) {
            var s = q.poll();
            if (res.contains(s))
                continue;
            int i = 0;
            while (i < primes100.length && s > primes100[i]) {
                if (s % primes100[i] == 0) {
                    q.add(s / primes100[i]);
                    res.add(s / primes100[i]);
                    res.add(primes100[i]);
                }
                i++;
            }
        }
        primeFactorMap.put(num, res);
        return res;
    }


    private int[][] cache;

    private int count[][];

    private boolean isPrime(int num) {
        for (int i = 0; i < primes100.length && num > primes100[i]; i++) {
            if (num % primes100[i] == 0)
                return false;
        }
        return true;
    }


    private int useDP(int n, int maxValue) {
        Set<Integer>[] divisible = new Set[maxValue + 1];
        divisible[1] = new HashSet<>();
        for (int i = 2; i <= maxValue; i++) {
            divisible[i] = new HashSet<Integer>();
            divisible[i].addAll(getFactor(i));
        }

        int[] dp = new int[maxValue + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = maxValue; j > 0; j--) {
                dp[j]++;
                for (var k : divisible[j]) {
                    dp[j] = (dp[j] + dp[k]) % MOD;
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= maxValue; i++) {
            res = (res + dp[i]) % MOD;
        }
        return res;

    }
/**
 * 1: 1
 * 2: 37
 * 3: 37
 * 4: 703
 * 5: 37
 * 6: 1369
 * 7: 37
 * 8: 9139
 * 9: 703
 * 10: 1369
 * 11: 37
 * 12: 26011
 * 13: 37
 * 14: 1369
 * 15: 1369
 * 16: 91390
 */
/**
 4   3   2   1   0
 2:  1:  1:  1:  1:
 2:  1:  1:  1:
 2:  1:  1:
 2:  1:
 2:


 0   1   2   3   4
 1   1   1   1   1   1
 2   1   2   3   4   5
 3   1   2   3   4   5


 n = 6   max = 6
 0   1   2   3   4   5
 1   1   1   1   1   1   1
 2   1   2   3   4   5   6
 3   1   2   3   4   5   6
 4   1   3   6   10  15  21
 5   1   2   3   4   5   6
 6   1   4   9   16  25  36


 1   2   3   4   5   6
 0   1   1   1   1   1   1
 1   1   2   2   3   2   4
 2   1   3   3   6   3   9
 3   1   4   4   10  4   16
 4   1   5   5   15  5   25
 5   1   6   6   20  6   36
 5   10  10


 dp[0][1] = 1
 dp[0][2] = 1
 dp[1][1] = 1
 dp[1][2] = 2
 dp[2][1] = 1
 dp[2][2] = 3
 dp[3][1] = 1
 dp[3][2] = 4
 dp[4][1] = 1
 dp[4][2] = 5


 */
}
