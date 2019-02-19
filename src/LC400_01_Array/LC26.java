package LC400_01_Array;

/**
 * Created by Gary on 11/24/18.
 */
public class LC26 {
    public int removeDuplicates(int[] nums) {
        // 双指针
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }
}
