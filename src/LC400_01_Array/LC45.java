package LC400_01_Array;

/**
 * Created by Gary on 12/10/18.
 */
public class LC45 {
    public int jump(int[] nums) {
        int[] pre = new int[nums.length]; //pre[i] keep the last position which can jump to i
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] > reach) { // reach+1 ... i+A[i] are reached by jumping from i
                for (int j = reach + 1; j <= i + nums[i] && j < nums.length; j++) {
                    pre[j] = i;
                }
                reach = i + nums[i];
            }
        }
        int ans = 0;
        int k = nums.length - 1;
        while (k > 0) {
            k = pre[k];
            ans++;
        }
        return ans;
    }
}
