package LC400_05_BackTracking;

/**
 * Created by Gary on 2019-01-13.
 */
public class LC377 {
    /*
     LC400_06_DP: 例如，给定[a,b,c],找出和为5的组合的个数。
     假设函数为f(target)表示：用给定的数组构造出和为target的数组的个数。
     那么 和为5的数组的个数 = 和为(5-a)的组合的个数 + 和为(5-b)的组合的个数 + 和为(5-c)的组合的个数
     即 f(5) = f(5-a) + f(5-b) + f(5-c);
     得到状态转移方程：
     f(target) = f(target - nums[0]) + f(target-nums[1]) + f(target-nums[2]) + ... + f(target - nums[nums.length - 1]);
     这时就要判断 target - nums[i]的合法性 需要>= 0

     LC400_06_DP[0] : 和为0的组合的个数，只有1种情况，什么都不选。所以DP[0] = 1
     */
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;
        if (nums == null || nums.length == 0) return 0;
        // dp 存放每一个中间状态的结果
        int[] dp = new int[target + 1];
        dp[0] = 1; //和为0的组合，什么都不选，只有这一种情况
        // 从1-target构造DP数组
        for (int t = 1; t <= target; t++) {
            for (int curValue : nums) {
                int remainder = t - curValue;
                if (remainder >= 0) {
                    dp[t] += dp[remainder];
                }
            }
        }
        return dp[target];
    }
}
