package LC400_01_Array;

/**
 * Created by Gary on 2018-12-25.
 */
public class LC152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        if (nums.length == 1)                   return nums[0];
        int currentMax = nums[0], currentMin = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int candidate1 = nums[i];
            int candidate2 = nums[i] * currentMax;
            int candidate3 = nums[i] * currentMin;
            currentMax = Math.max(Math.max(candidate1, candidate2), candidate3);
            currentMin = Math.min(Math.min(candidate1, candidate2), candidate3);
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
