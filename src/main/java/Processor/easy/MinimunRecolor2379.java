package src.main.java.Processor.easy;

public class MinimunRecolor2379 {

    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int currentStep = 0;
        for(left = 0; left<k; left ++) {
            if (blocks.charAt(left) == 'W') {
                currentStep++;
            }
        }
        int min = currentStep;
        for(;left < blocks.length(); left++) {
            if (!(blocks.charAt(left-k) == blocks.charAt(left))) {
                if (blocks.charAt(left) == 'W') {
                    currentStep++;
                } else {
                    currentStep--;
                }
            }
            if (currentStep < min) {
                min = currentStep;
            }
            if (min==0)
                break;
        }

        return min;
    }

}
