package LC400_03_Math;

import java.util.Arrays;

/**
 * Created by Gary on 2019-02-28.
 */
public class Math17_LC_016 {
    // time : O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        // 因为题目假设每个输入都刚好有一个解，可以先进行一下初始化
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        // 排序
        Arrays.sort(nums);
        // 跟上个题一样，刚好覆盖完
        for (int i = 0; i < nums.length - 2; i++) {
            // 左指针指向当前的下一个，右指针指向最后一个
            int start = i + 1, end = nums.length - 1;
            // 从两边向中间夹
            while (start < end) {
                // 计算出一个sum值
                int sum = nums[i] + nums[start] + nums[end];
                // 若目标值小于sum，右指针向左，使得sum靠近target
                if (sum > target) end--;
                    // 反之，左指针向右，使得sum靠近target
                else start++;
                // 计算一下sum-target的绝对值是否比之前更小，小的话更新一下res
                res = (Math.abs(sum - target) < Math.abs(res - target)) ? sum : res;
            }
        }
        return res;
    }
}
