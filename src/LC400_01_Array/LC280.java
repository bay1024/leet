package LC400_01_Array;

import java.util.Arrays;

/**
 * Created by Gary on 2018-12-25.
 */
public class LC280 {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isEven = i % 2 == 0;
            boolean isDecrease = nums[i] > nums[i + 1];
            if (isEven && isDecrease || !isEven && !isDecrease) {
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 2, 3, 1};
        LC280 solution = new LC280();
        solution.wiggleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}

