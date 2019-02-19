package LC400_01_Array;

/**
 * Created by Gary
 */
public class LC275 {
    // [0,1,3,5,6]
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int right = n - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] < n - mid) left = mid + 1;
            else right = mid - 1;
        }
        return n - left;
    }
}
