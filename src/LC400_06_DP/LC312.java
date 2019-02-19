package LC400_06_DP;

/**
 * Created by Gary on 2019-01-07.
 */
public class LC312 {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        // 先去掉所有数字为0的气球
        for (int x : iNums) {
            if (x > 0) nums[n++] = x;
        }
        nums[0] = nums[n++] = 1;
        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }

    private int burst(int[][] memo, int[] nums, int left, int right) {
        // base case
        if (left + 1 == right)      return 0;
        if (memo[left][right] > 0)  return memo[left][right];

        int ans = 0;
        for (int i = left + 1; i < right; ++i) {
            // 总硬币数 = 戳破该气球的硬币+ 戳破左边部分的硬币 + 戳破右边部分的硬币
            int total = nums[left] * nums[i] * nums[right]
                    + burst(memo, nums, left, i)
                    + burst(memo, nums, i, right);
            ans = Math.max(ans, total);
        }
        memo[left][right] = ans;
        return ans;
    }
}
