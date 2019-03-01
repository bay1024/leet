package LC400_09_Matrix;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        int si = 0, ei = 0, inc = 0;
        for (int[] update : updates) {
            si = update[0];
            ei = update[1];
            inc = update[2];
            if (si - 1 >= 0) {
                res[si - 1] -= inc;
            }
            res[ei] += inc;
        }
        for (int i = res.length - 1 - 1; i >= 0; i--) {
            res[i] += res[i + 1];
        }
        return res;
    }
}
