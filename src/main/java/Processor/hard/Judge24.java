package src.main.java.Processor.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Judge24 {
    class Solution {
        private static final double TARGET = 24.0;
        private static final double ESP = 0.00001;
        private static Map<String, Boolean> CACHE = new HashMap<>();

        public boolean judgePoint24(int[] cards) {
            Arrays.sort(cards);
            String key = cards[0] + "-" + cards[1] + "-" + cards[2] + "-" + cards[3];
            if (CACHE.containsKey(key)) {
                return CACHE.get(key);
            }
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    for (int k = 0; k < 4; k++) {
                        if (makePerAndCheck(cards, i, j, k)) {
                            CACHE.put(key, true);
                            return true;
                        }
                    }
            CACHE.put(key, false);
            return false;
        }

        private boolean makePerAndCheck(int[] cards, int sign1, int sign2, int sign3) {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++) {
                    if (j == i) continue;
                    for (int k = 0; k < 4; k++) {
                        if (k == i || k == j) continue;
                        for (int t = 0; t < 4; t++) {
                            if (t == i || t == j || t == k) continue;
                            if (calculate4(sign1, sign2, sign3, cards[i], cards[j], cards[k], cards[t]))
                                return true;
                        }
                    }
                }
            return false;
        }

        private boolean calculate4(int sign1, int sign2, int sign3, double A, double B, double C, double D) {
            if (equals(calculate2(sign1, A, calculate3(sign2, sign3, B, C, D))))
                return true;
            if (equals(calculate2(sign1, A, calculate2(sign2, B, calculate2(sign3, C, D)))))
                return true;
            if (equals(calculate2(sign1, A, calculate2(sign3, calculate2(sign2, B, C), D))))
                return true;
            if (equals(calculate3(sign2, sign3, calculate2(sign1, A, B), C, D)))
                return true;
            if (equals(calculate2(sign2, calculate2(sign1, A, B), calculate2(sign3, C, D))))
                return true;
            if (equals(calculate2(sign3, calculate3(sign1, sign2, A, B, C), D)))
                return true;
            return false;
        }

        private boolean equals(double a) {
            return Math.abs(a - TARGET) < ESP;
        }

        private double calculate3(int sign1, int sign2, double A, double B, double C) {
            if ((sign1 == 0 || sign1 == 1) && (sign2 == 2 || sign2 == 3))
                return calculate2(sign1, A, calculate2(sign2, B, C));
            return calculate2(sign2, calculate2(sign1, A, B), C);
        }

        private double calculate2(int sign, double A, double B) {
            return switch (sign) {
                case 0 -> A + B;
                case 1 -> A - B;
                case 2 -> A / B;
                case 3 -> A * B;
                default -> 0.0;
            };
        }
    }
}
