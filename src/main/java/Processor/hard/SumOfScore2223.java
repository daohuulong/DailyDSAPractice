package src.main.java.Processor.hard;

public class SumOfScore2223 {
    private static int MOD = 1_000_000_007;
    private static int BASE = 27;

    /**
     *
     * Approach: Rolling Hash + Binary Search
     * @param s
     * @return
     */
    public long sumScores(String s) {
        int n = s.length();
        long[] hash = new long[n + 1];
        long[] pow = new long[n + 1];
        pow[0] = 1;
        //build hash array
        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * BASE) % MOD;
            hash[i] = (hash[i - 1] * BASE + (s.charAt(i - 1) - 'a' + 1)) % MOD;
        }
        long res = n;
        for (int i = 1; i < n; i++) {
            //find longest prefix
            int l = i;
            int r = n;
            long longestPrefix = l;
            while (l <= r) {
                int mid = (l + r) / 2;
                long hashSi = (hash[mid] - (hash[i] * pow[mid - i] % MOD) + MOD) % MOD;
                //hashSi == hashSn mean the longest prefix maybe longer than mid
                if (hashSi == hash[mid - i]) {
                    longestPrefix = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            res += (longestPrefix - i);
        }
        return res;
    }
}
