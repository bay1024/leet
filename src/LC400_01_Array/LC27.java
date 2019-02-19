package LC400_01_Array;

/**
 * Created by Gary on 11/24/18.
 */
public class LC27 {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }
}
