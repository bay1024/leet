package LC400_03_Math;

import java.util.Arrays;

/**
 * Created by Gary on 2019-03-02.
 */
public class Math18_LC_259 {
    // time : O(n ^ 2)      space : O(1)
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;      // 保存个数
        Arrays.sort(nums);  // 排序
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1, right = len - 1;
            while (left < right) {
                // 找到满足条件的组
                if (nums[i] + nums[left] + nums[right] < target) {
                    // target这时候都比sum大，right 从right到left+1的这些组只会让sum更小，target肯定大。
                    // 把这些情况都加到count上。
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
