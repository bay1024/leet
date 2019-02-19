package LC400_06_DP;

import java.util.TreeSet;

/**
 * Created by Gary on 2019-01-09.
 */
public class LC363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        if (n == 0)    return 0;
        int M = Math.max(m, n);
        int N = Math.min(m, n);

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int[] sums = new int[M];
            for (int j = i; j < N; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                int num = 0;
                for (int x = 0; x < M; x++) {
                    sums[x] += m > n ? matrix[x][j] : matrix[j][x];
                    num += sums[x];
                    if (num <= k) res = Math.max(res, num);
                    Integer t = set.ceiling(num - k);
                    if (t != null) res = Math.max(res, num - t);
                    set.add(num);
                }
            }
        }
        return res;
    }
}
