package src.main.java.Processor.easy;

public class LongestCommonPrefix14 {
    private String prefix(String a, String b) {
        StringBuilder prefix = new StringBuilder();
        var minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                break;
            }
            prefix.append(a.charAt(i));
        }
        return prefix.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";
        String longestPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            longestPrefix = prefix(longestPrefix, strs[i]);
            if (longestPrefix.isEmpty())
                break;
        }
        return longestPrefix;
    }

}
