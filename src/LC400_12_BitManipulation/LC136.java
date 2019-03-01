package LC400_12_BitManipulation;

/**
 * Created by Gary on 2019-02-23.
 */
public class LC136 {
    // 4 2 1 1 2
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] ^= nums[i - 1];
        }
        return nums[nums.length - 1];
    }
}
