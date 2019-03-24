package LC400_03_Math;

/**
 * Created by Gary on 2019-03-03.
 */
public class Math33_LC_172 {
    public int trailingZeroes(int n) {
        if (n < 0) return -1;
        int count = 0;
        long i = 5;
        for (; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
