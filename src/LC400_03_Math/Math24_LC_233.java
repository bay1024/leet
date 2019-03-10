package LC400_03_Math;

/**
 * Created by Gary on 2019-03-02.
 */
public class Math24_LC_233 {
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n / m + 8) / 10 * m + (n / m % 10 == 1 ? n % m + 1 : 0);
        return ones;
    }

    public static void main(String[] args) {
        Math24_LC_233 solution = new Math24_LC_233();
        System.out.println(solution.countDigitOne(12));
    }
}
