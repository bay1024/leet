package LC400_12_BitManipulation;

/**
 * Created by Gary on 2019-02-26.
 */
public class LC201 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}
