public class Primer {
    public static void main(String[] args) {
        int numPrimes = 0;
        int num = 2;
        while (numPrimes < 5) {
            if (isPrime(num)) {
                numPrimes++;
            }
            num++;
        }
        System.out.println(num - 1);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}