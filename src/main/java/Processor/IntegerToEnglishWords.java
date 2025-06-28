package src.main.java.Processor;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
    public static final Map<Integer, String> NUMBER_WORDS_0_19  = new HashMap<>();
    public static final Map<Integer, String> NUMBER_WORDS_20_90 = new HashMap<>();
    public static final Map<Integer, String> LARGE_NUMBER_WORDS = new HashMap<>();

    static {
        NUMBER_WORDS_0_19.put(0, "zero");
        NUMBER_WORDS_0_19.put(1, "one");
        NUMBER_WORDS_0_19.put(2, "two");
        NUMBER_WORDS_0_19.put(3, "three");
        NUMBER_WORDS_0_19.put(4, "four");
        NUMBER_WORDS_0_19.put(5, "five");
        NUMBER_WORDS_0_19.put(6, "six");
        NUMBER_WORDS_0_19.put(7, "seven");
        NUMBER_WORDS_0_19.put(8, "eight");
        NUMBER_WORDS_0_19.put(9, "nine");
        NUMBER_WORDS_0_19.put(10, "ten");
        NUMBER_WORDS_0_19.put(11, "eleven");
        NUMBER_WORDS_0_19.put(12, "twelve");
        NUMBER_WORDS_0_19.put(13, "thirteen");
        NUMBER_WORDS_0_19.put(14, "fourteen");
        NUMBER_WORDS_0_19.put(15, "fifteen");
        NUMBER_WORDS_0_19.put(16, "sixteen");
        NUMBER_WORDS_0_19.put(17, "seventeen");
        NUMBER_WORDS_0_19.put(18, "eighteen");
        NUMBER_WORDS_0_19.put(19, "nineteen");

        NUMBER_WORDS_20_90.put(20, "twenty");
        NUMBER_WORDS_20_90.put(30, "thirty");
        NUMBER_WORDS_20_90.put(40, "forty");
        NUMBER_WORDS_20_90.put(50, "fifty");
        NUMBER_WORDS_20_90.put(60, "sixty");
        NUMBER_WORDS_20_90.put(70, "seventy");
        NUMBER_WORDS_20_90.put(80, "eighty");
        NUMBER_WORDS_20_90.put(90, "ninety");

        LARGE_NUMBER_WORDS.put(100, "hundred");
        LARGE_NUMBER_WORDS.put(1000, "thousand");
        LARGE_NUMBER_WORDS.put(1000000, "million");
        LARGE_NUMBER_WORDS.put(1000000000, "billion");

    }

    public String render2Words(int number) {
        if (number > 99)
            return "";
        if (number < 20)
            return NUMBER_WORDS_0_19.get(number);
        return NUMBER_WORDS_20_90.get(number / 10) + ((number % 10) != 0 ? " " + NUMBER_WORDS_0_19.get(number % 10) : "");
    }

    public String render3Words(int number) {
        if (number > 999)
            return "";
        if (number < 100)
            return render2Words(number);
        var t = number / 100;
        var words2 = number % 100;
        return NUMBER_WORDS_0_19.get(t) + render2Words(words2);
    }
}
