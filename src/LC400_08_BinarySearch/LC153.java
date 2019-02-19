package LC400_08_BinarySearch;

/**
 * Created by Gary on 2019-02-02.
 */
public class LC153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1, mid;
        int target = nums[right];
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) right = mid;
            else left = mid;
        }
        if (nums[left] <= target) return nums[left];
        return nums[right];
    }
}
