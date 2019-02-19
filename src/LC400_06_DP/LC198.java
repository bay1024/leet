package LC400_06_DP;

/**
 * Created by Gary on 2019-01-09.
 */
public class LC198 {
    /*
     * 用三个变量来替换掉space为O(n)的数组,max, prepre:, pre
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = 0, prepre = 0, pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(pre, prepre + nums[i]);
            prepre = pre;
            pre = max;
        }
        return max;
    }

    public static int rob(int[] nums) {
        int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
        for (int i = 0; i < nums.length; i++) {
            rob = preNotRob + nums[i];
            notRob = Math.max(preRob, preNotRob);
            preNotRob = notRob;
            preRob = rob;
        }
        return Math.max(rob, notRob);
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
