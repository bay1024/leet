package LC400_03_Math;

/**
 * Created by Gary on 2019-03-03.
 */
public class Math37_LC_357 {
    public int countNumbersWithUniqueDigits(int n) {
        n = Math.min(n, 10);
        int[] result = new int[n + 1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            result[i] = 9;
            for (int j = 9; j >= 11 - i; j--) {
                result[i] *= j;
            }
        }
        int max = 0;
        for (int i = 0; i < result.length; i++) {
            max += result[i];
        }
        return max;
    }
}
