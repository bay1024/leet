package LC400_01_Array;

import java.util.Arrays;

/**
 * Created by Gary on 11/25/18.
 */
public class LC189 {
    /** 方法1: 暴力 time: O(n*k); space:   O(1)*/
    public void rotate0(int[] nums, int k) {
        if (nums == null || nums.length <= 1)   return;
        // 减少不必要的次数
        // 例如：移动step如果是数组长度的话，结果和原数组相同
        k = k % nums.length;

        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /** 方法2: 使用额外数组. Time O(n); Space O(n)*/
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length <= 1)   return;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 计算好每一个元素应该放置的位置，进行放入
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    /** 方法3: . Time O(n); Space O(n)*/
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length <= 1)   return;
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
            System.out.println(Arrays.toString(nums));
        }
    }

    /** 方法4: 三步翻转*/
    public void rotate4(int[] nums, int k) {
        if (nums == null || nums.length <= 1)   return;
        k = k % nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    private void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int k = 3;
        new LC189().rotate2(arr, k);
        System.out.println("result:" + Arrays.toString(arr));
    }
}
