package LC400_01_Array;

/**
 * Created by Gary on 2018-12-25.
 */
public class LC283 {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }
}
