package LC400_06_DP;

/**
 * Created by Gary on 2019-01-09.
 */
public class LC213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(help(nums, 0, nums.length - 2), help(nums, 1, nums.length - 1));
    }

    private int help(int[] nums, int left, int right) {
        int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
        for (int i = left; i <= right; i++) {
            rob = preNotRob + nums[i];
            notRob = Math.max(preRob, preNotRob);

            preNotRob = notRob;
            preRob = rob;
        }
        return Math.max(rob, notRob);
    }
}
