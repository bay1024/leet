package LC400_03_Math;

/**
 * Created by Gary on 2019-03-03.
 */
public class Math39_LC_397 {
    public int integerReplacement(int n) {
        int c = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || ((n >>> 1) & 1) == 0) {
                --n;
            } else {
                ++n;
            }
            ++c;
        }
        return c;
    }
}