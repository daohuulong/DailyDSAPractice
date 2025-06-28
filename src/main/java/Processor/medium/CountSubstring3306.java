package src.main.java.Processor.medium;

public class CountSubstring3306 {

    static final int CONSONANT_IDX = 0;
    static final int VOWEL_A_IDX = 1;
    static final int VOWEL_E_IDX = 2;
    static final int VOWEL_I_IDX = 3;
    static final int VOWEL_O_IDX = 4;
    static final int VOWEL_U_IDX = 5;
    int[] countChar;

    private int getIndex(char c) {
        switch (c) {
            case 'a':
                return VOWEL_A_IDX;
            case 'e':
                return VOWEL_E_IDX;
            case 'i':
                return VOWEL_I_IDX;
            case 'o':
                return VOWEL_O_IDX;
            case 'u':
                return VOWEL_U_IDX;
            default:
                return CONSONANT_IDX;
        }
    }

    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        countChar = new int[6];
        int left = 0;
        int right = 0;
        int result = 0;
        addChar(word.charAt(right));
        int countValid = 0;
        right++;
        while ( (right < n)) {
            addChar(word.charAt(right));
            if (getIndex(word.charAt(right))==0)
                countValid = 0;
            while (countChar[CONSONANT_IDX] > k) {
                removeChar(word.charAt(left));
                left++;
            }
            while (left < n && (checkVowelCondition() && countChar[CONSONANT_IDX] == k)) {
                countValid++;
                removeChar(word.charAt(left));
                left++;
            }
            result+=countValid;
            right++;
        }
        return result;
    }

    private void addChar(char c) {
        countChar[getIndex(c)]++;
    }

    private void removeChar(char c) {
        countChar[getIndex(c)]--;
    }

    private boolean checkVowelCondition() {
        for (char i : "aeiou".toCharArray()) {
            if (countChar[getIndex(i)] == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        CountSubstring3306 countSubstring3306 = new CountSubstring3306();
        System.out.println(countSubstring3306.countOfSubstrings("abcabcabc", 2));
    }
}
