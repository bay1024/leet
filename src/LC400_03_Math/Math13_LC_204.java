package LC400_03_Math;

/**
 * Created by Gary on 2019-02-27.
 */
public class Math13_LC_204 {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int result = 0;
        boolean[] prime = new boolean[n];
        for (int i = 2; i < n; i++) {
            prime[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            if (prime[i]) {
                for (int j = i + i; j < n; j = j + i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (prime[i]) result++;
        }
        return result;
    }
}
