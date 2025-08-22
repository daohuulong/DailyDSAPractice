package src.main.java.Util.Primes;

public class PrimeList {
    private static final int MAX = 1100;

    public static void main(String[] args){

        System.out.println("{");
        for(int i = 2; i < MAX; i++) {
            if(isPrime(i)) {
                System.out.print(i + ",");
            }
        }
        System.out.println("}");
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
