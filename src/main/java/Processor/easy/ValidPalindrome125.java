package Processor.easy;

import java.util.regex.Pattern;

public class ValidPalindrome125 {

    private static final String TEMPLATE = "[^\\p{L}\\d]";
    private static final Pattern PATTERN = Pattern.compile(TEMPLATE);
    private boolean isNonAlphanumeric(char s) {
        return Character.isLetterOrDigit(s);
    }

    private boolean equalIgnoreCase(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

    public boolean isPalindrome(String s) {
        //Use 2 pointer, one start from left to right, one start form right to left.
        //We loop through the string, stop when left >= right
        //step in loop:
        //1: if s[left] is non-alphanumeric we skip and increase left
        //2: if s[right] is non-alphanumeric we skip and decrease right
        //3: convert s[left] and s[right] to lowercase and compare.
        //3.1: if s[left] == s[right] increase both left and right and continue
        //3.2: else return false
        //finally return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (isNonAlphanumeric(s.charAt(left))) {
                left++;
                continue;
            }
            if (isNonAlphanumeric(s.charAt(right))) {
                right--;
                continue;
            }
            if (!equalIgnoreCase(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
