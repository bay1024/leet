package LC400_12_BitManipulation;

/**
 * Created by Gary on 2019-02-26.
 */
public class LC190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++, n >>= 1) {
            res = res << 1 | (n & 1);
        }
        return res;
    }
}
