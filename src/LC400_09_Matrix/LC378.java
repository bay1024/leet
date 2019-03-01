package LC400_09_Matrix;

import java.util.PriorityQueue;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int num = count(matrix, mid);
            if (num >= k) right = mid;
            else left = mid;
        }
        if (count(matrix, right) <= k - 1) return right;
        return left;
    }

    private int count(int[][] matrix, int target) {
        int n = matrix.length;
        int res = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] < target) {
                res += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return res;
    }

    class MyData {
        int value;
        int x;
        int y;

        public MyData(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<MyData> pq = new PriorityQueue<>((a, b) -> (a.value - b.value));
        for (int i = 0; i < matrix[0].length; i++) {
            pq.add(new MyData(matrix[0][i], 0, i));
        }
        for (int i = 0; i < k - 1; i++) {
            MyData d = pq.poll();
            int row = d.x + 1;
            if (row >= matrix.length) continue;
            else pq.add(new MyData(matrix[row][d.y], row, d.y));
        }
        return pq.poll().value;
    }
}
