package LC400_01_Array;

/**
 * Created by Gary on 11/27/18.
 */
public class LC41 {

    // time: O(n) space: O(1)
    public int firstMissingPositive(int[] nums) {
        if (nums == null)   return 1;
        int length = nums.length;
        if (length == 0)    return 1;

        int k = partition(nums) + 1;
        for (int i = 0; i < k; i++) {
            int temp = Math.abs(nums[i]);
            if (temp <= k) {
                int value = nums[temp - 1];
                if (value > 0) {
                    nums[temp - 1] = -value;
                }
            }
        }

        int firstMissingIndex = k;
        for (int i = 0; i < k; i++) {
            if (nums[i] > 0) {
                firstMissingIndex = i;
                break;
            }
        }
        return firstMissingIndex + 1;
    }

    private int partition(int[] nums) {
        int partition = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                partition++;
                swap(nums, partition, i);
            }
        }
        return partition;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
