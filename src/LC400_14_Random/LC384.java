package LC400_14_Random;

import java.util.Random;

/**
 * Created by Gary on 2019-01-31.
 */
class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() { return nums; }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] result = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int index = random.nextInt(nums.length);
            swap(index, i, result);
        }
        return result;
    }

    private void swap(int i, int j, int[] result) {
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
    }
}

public class LC384 {

}
