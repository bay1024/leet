package LC400_08_BinarySearch;

/**
 * Created by Gary on 2019-02-02.
 */
public class LC35 {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        int start = 0, end = nums.length - 1;
        int mid;
        // find the last number less than target
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid;
            else end = mid;
        }
        if (nums[end] == target) return end;
        if (nums[end] < target) return end + 1;
        if (nums[start] == target) return start;
        return start + 1;
    }
}
