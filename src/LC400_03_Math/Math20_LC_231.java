package LC400_03_Math;

/**
 * Created by Gary on 2019-03-02.
 */
public class Math20_LC_231 {
    /**
     * 2 :      10
     * 4 :     100
     * 8 :    1000
     * ...
     * 8 & (8 - 1)      1000
     *                 &0111
     *                  0000
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
