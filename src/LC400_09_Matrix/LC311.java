package LC400_09_Matrix;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC311 {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colB = B[0].length;
        int colA = A[0].length;
        int[][] result = new int[rowA][colB];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colA; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < colB; k++) {
                        if (B[j][k] != 0) {
                            result[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return result;
    }
}
