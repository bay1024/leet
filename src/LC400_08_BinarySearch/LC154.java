package LC400_08_BinarySearch;

/**
 * Created by Gary on 2019-02-02.
 */
public class LC154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            } else { // nums[left] <= nums[mid] <= nums[right]
                right--;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
