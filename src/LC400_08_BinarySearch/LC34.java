package LC400_08_BinarySearch;

/**
 * Created by Gary on 2019-02-05.
 */
public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        res[0] = searchLeft(nums, target);
        res[1] = searchRight(nums, target);
        return res;
    }

    // 搜索右边界
    private int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + ((right - left) >> 1);
            // 因为要找最右边的目标，目标大于等于mid都要移动左指针
            if (target >= nums[mid]) left = mid;
            else right = mid;
        }
        // 循环结束后先判断右边是否等于目标
        if (nums[right] == target) return right;
        // 再判断左边是否等于目标
        if (nums[left] == target) return left;
        // 都不等，没找到
        return -1;
    }

    // 搜索左边界
    private int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + ((right - left) >> 1);
            // 因为要找最左边的目标，目标小于等于mid都要移动右指针
            if (target <= nums[mid]) right = mid;
            else left = mid;
        }
        // 循环结束后先判断左边是否等于目标
        if (nums[left] == target) return left;
        // 再判断右边是否等于目标
        if (nums[right] == target) return right;
        // 都不等，没找到
        return -1;
    }
}
