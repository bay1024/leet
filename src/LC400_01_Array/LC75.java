package LC400_01_Array;

/**
 * Created by Gary on 2018-12-25.
 */
public class LC75 {
    private void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }

    // 一遍遍历
    public void sortColors(int[] A) {
        int len = A.length;
        int i, r = 0, b = 0;
        for (i = 0; i < len - b; i++) {
            if (A[i] == 0) {
                swap(A, i, r);
                r++;
            } else if (A[i] == 2) {
                swap(A, i, len - 1 - b);
                b++;
                i--; //后面交换过来的元素也要进行判断
            }
        }
    }
}
