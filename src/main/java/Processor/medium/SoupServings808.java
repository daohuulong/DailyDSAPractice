package src.main.java.Processor.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SoupServings808 {
    public static class Solution {
        static double[][] dp = new double[4801][4801];

        public Solution() {
            for (var d : dp) {
                Arrays.fill(d, -1.0);
            }
        }
        public double soupServings(int n) {
            if (n >= 4800)
                return 1;
            return Math.round(serving(n, n) * 100_000) / 100_000.0;
        }

        private static final int[][] OPERATIONS = new int[][] {
                { 100, 0 },
                { 75, 25 },
                { 50, 50 },
                { 25, 75 }
        };

        private double serving(int A, int B) {
            if (dp[A][B] > -1.0) {
                return dp[A][B];
            }
            if (A == 0 && B == 0)
                return 0.5;
            if (A == 0)
                return 1;
            if (B == 0)
                return 0;
            double res = 0;
            for (var op : OPERATIONS) {
                res += 0.25 * (serving(Math.max(A - op[0], 0), Math.max(B - op[1], 0)));
            }
            dp[A][B] = res;
            return res;
        }
    }

    public static void main(String[] agrs) {
        Solution rs = new Solution();
        double[] result = new double[4801];
        for (int i = 0; i < 4801; i++) {
            result[i] = rs.soupServings(i);
        }

        long[][] temp = new long[180][];
        int idx = 0;
        int left = 0;
        for (int i = 0; i < 4801; i++) {
            if(Double.compare(result[i], result[left]) > 0) {
                temp[idx] = new long[] {(i-1), (long)(100_000 * result[left] )};
                left = i;
                idx++;
            }
        }
        for(var t : temp)
            System.out.println(Arrays.toString(t));

    }

    public String largestGoodInteger(String num) {
        return Stream.of("000", "111", "222", "333", "444", "555", "666", "777", "888", "999")
                .filter(num::contains)
                .max(Comparator.naturalOrder())
                .orElse("");
    }

    /**
     * Tìm tất cả các chuỗi con có 3 ký tự giống nhau liên tiếp trở lên
     * @param input chuỗi đầu vào
     * @return danh sách các chuỗi con tìm được
     */
    public static List<String> findRepeatedChars(String input) {
        List<String> results = new ArrayList<>();

        // Regex pattern: (.) - capture group cho 1 ký tự bất kỳ
        // \1{2,} - match với ký tự đó lặp lại ít nhất 2 lần nữa (tổng cộng ít nhất 3 lần)
        String regex = "((.)\\2{2,})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Tìm tất cả các match
        while (matcher.find()) {
            results.add(matcher.group(1).substring(0, 3));
        }

        return results;
    }
}
