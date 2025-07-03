package src.main.java.Processor.easy;

public class FindKthChar3304 {
    class Solution {
        public char kthCharacter(int k) {
            return binary(k);
        }

        private char binary(int k) {
            int count = 0;
            while (k > 1) {
                int max = 1;
                while (max * 2 < k) {
                    max *= 2;
                }
                k -= max;
                count++;
            }
            return (char) ((count % 26) + 'a');
        }

        private char loopK(int k) {
            StringBuilder sb = new StringBuilder();
            sb.append('a');
            int l = 1;
            for (int i = 1; i < k; i++) {
                int c = sb.charAt((i % l));
                c = ((c + 1 - 'a') % 26) + 'a';
                sb.append((char) c);
                if (sb.length() >= l * 2)
                    l *= 2;
            }
            return sb.charAt(k - 1);
        }

        private char doubleString(int k) {
            String res = "a";
            while (res.length() < k) {
                StringBuilder sb = new StringBuilder();
                sb.append(res);
                int remain = Math.min(res.length(), k - res.length());
                for (int i = 0; i < remain; i++) {
                    int c = sb.charAt(i);
                    c = (((c - 'a' + 1) % 26) + 'a');
                    sb.append((char) c);
                }
                res = sb.toString();
            }
            return res.charAt(k - 1);
        }
    }}
