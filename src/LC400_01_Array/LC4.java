package LC400_01_Array;

/**
 * Created by Gary on 12/21/18.
 */
public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (findkth(nums1, 0, nums2, 0, l) + findkth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private double findkth(int[] a, int start1, int[] b, int start2, int k) {
        if (start1 > a.length - 1) return b[start2 + k - 1];//there is no number available in a
        if (start2 > b.length - 1) return a[start1 + k - 1];//there is no number available in b
        if (k == 1) return Math.min(a[start1], b[start2]);//there is only one number available

        int key1 = start1 + k / 2 - 1 < a.length ? a[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int key2 = start2 + k / 2 - 1 < b.length ? b[start2 + k / 2 - 1] : Integer.MAX_VALUE;

        if (key1 < key2) return findkth(a, start1 + k / 2, b, start2, k - k / 2);
        else return findkth(a, start1, b, start2 + k / 2, k - k / 2);
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 7, 9};
        int[] numbers2 = {1, 2, 4, 10, 13};
        System.out.println(new LC4().findMedianSortedArrays(numbers1, numbers2));
    }
}
