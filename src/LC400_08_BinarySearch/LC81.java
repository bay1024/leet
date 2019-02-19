package LC400_08_BinarySearch;

/**
 * Created by Gary on 2019-02-02.
 */
public class LC81 {
    public boolean search(int[] nums, int target) {
        // 边界，数组为空或者长度为0，肯定找不到target，返回-1
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            // 把相等的情况单独拿出来，直接返回结果即可，提高效率，且能把左中右三个边界用一行考虑完，下面的逻辑比较清晰
            if (nums[mid] == target || nums[left] == target || nums[right] == target) return true;
            if (nums[mid] > nums[left]) {
                if (nums[left] < target && target < nums[mid])  right = mid;
                else                                            left = mid;
            } else if (nums[mid] < nums[left]) {
                if (nums[mid] < target && target < nums[right]) left = mid;
                else                                            right = mid;
            } else {
                left++;
            }
        }
        return nums[left] == target || nums[right] == target;
    }
}
