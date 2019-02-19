package LC400_05_BackTracking;

import java.util.Arrays;

/**
 * Created by Gary on 2019-01-13.
 */
public class LC31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = len - 1;
        while (index > 0 && nums[index] <= nums[index - 1]) {
            index--;
        }
        if (index == 0) {
            Arrays.sort(nums);
            return;
        }
        int pos = -1;
        for (int i = len - 1; i >= index; i--) {
            if (nums[i] > nums[index - 1]) {
                pos = i;
                break;
            }
        }
        if (pos >= 0) {
            int temp = nums[index - 1];
            nums[index - 1] = nums[pos];
            nums[pos] = temp;
            reverse(nums, index, nums.length - 1);
        }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    void reverse(int[] a, int i, int j) {
        for (; i < j; i++, j--) {
            swap(a, i, j);
        }
    }
}
