package LC400_01_Array;

/**
 * Created by Gary on 11/24/18.
 */
public class LC26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
