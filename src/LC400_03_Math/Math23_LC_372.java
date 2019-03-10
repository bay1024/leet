package LC400_03_Math;

/**
 * Created by Gary on 2019-03-02.
 */
public class Math23_LC_372 {
    final int k = 1337;

    public int superPow(int a, int[] b) {
        int fac = a % 1337, l = b.length;
        int[] dp = new int[l];
        dp[0] = pMod(fac, b[l - 1]);
        for (int i = 1; i < l; i++) dp[i] = dp[i - 1] * pMod(fac = pMod(fac, 10), b[l - i - 1]) % k;
        return dp[l - 1];
    }

    // pMod is for calculating (a^b) mod 1337
    private int pMod(int a, int b) {
        return b == 0 ? 1 % k : b == 1 ? a % k : a % k * pMod(a, b - 1) % k;
    }
}
