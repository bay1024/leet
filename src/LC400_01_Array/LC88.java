package LC400_01_Array;

/**
 * Created by Gary on 2018-12-25.
 */
public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        m--; n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[index] = nums1[m];
                m--;
            } else {
                nums1[index] = nums2[n];
                n--;
            }
            index--;
        }
        if (m > n) {
            for (int i = m; i >= 0; i--) {
                nums1[index--] = nums1[i];
            }
        } else {
            for (int i = n; i >= 0; i--) {
                nums1[index--] = nums2[i];
            }
        }
    }
}
