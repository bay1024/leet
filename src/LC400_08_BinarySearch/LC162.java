package LC400_08_BinarySearch;

/**
 * Created by Gary on 2019-02-03.
 */

/**
 * 3 2 1
 * |   |
 */
public class LC162 {
    public int findPeakElement(int[] nums) {
        // 如果长度小于2，直接返回
        if (nums == null || nums.length < 2) return 0;
        // 如果长度刚好是2，则例如 -∞， 1， 2， -∞；较大的那个就是峰值；
        // 判断一下这种情况，在下面就不用考虑边界值了：mid - 1, mid + 1，就不会越界了
        if (nums.length == 2) {
            if (nums[0] >= nums[1]) return 0;
            return 1;
        }
        // 二分法开始找峰值
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            // 若mid大于或等于两边，则刚好就是峰值
            if (nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1]) return mid;
            // 如果mid值小于左边的元素，则说明左半部分有一个峰值，可以舍弃右半部分；right指针向左移动到mid，舍弃右边
            else if (nums[mid - 1] > nums[mid]) right = mid;
            // mid值大于左边的元素，则说明右半部分有一个峰值，可以舍弃左半部分；left指针向右移动到mid，舍弃左边
            else left = mid;
        }
        // 最终left和right挨在一起，较大的那个就是峰值
        if (nums[left] > nums[right]) return left;
        return right;
    }
}

