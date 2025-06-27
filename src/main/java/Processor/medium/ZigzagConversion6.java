package Processor.medium;

public class ZigzagConversion6 {
    /**
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        int delta = 2 * (numRows - 1);

        for (int i = 0; i < numRows; i++) {
            int start = i;
            while (start < s.length()) {
                result.append(s.charAt(start));
                start += delta;
                if (i > 0 && i < numRows -1) {
                    if ( start - (i * 2) < s.length())
                        result.append(s.charAt(start - (i * 2)));
                }
            }
        }
        return result.toString();
    }
}
