package LC400_01_Array;

/**
 * Created by Gary on 2018-12-25.
 */
public class LC238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        // [1, 2, 3, 4]
        // [1, 1, 2, 6]
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int right = 1;
        // [1, 2, 3, 4]
        // [1, 1, 2, 6]
        // [24, 12, 8, 6]
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = right * result[i];
            right = right * nums[i];
        }
        return result;
    }
}
