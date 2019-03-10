package LC400_03_Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gary on 2019-02-28.
 */
public class Math16_LC_15 {
    // time : O(n^2)    space : O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);
        // 在倒数第三个位置停，因为这时low是倒数第二个位置，high是最后一个位置，刚好覆盖
        for (int i = 0; i < nums.length - 2; i++) {
            // 若当前值和上一个值一样，跳过即可，避免重复
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
            // 从low指向当前位置的下一个，high指向最后一个，判断是否能找到和为 0-nums[i]的值
            while (low < high) {
                // 找到
                if (nums[low] + nums[high] == sum) {
                    // 把三个值加入到结果集中
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    // 左边去重，即跳过相同的元素
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    // 右边去重
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    // 左右各自向中间走一步，继续找
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) { // 如果左右相加比较小，左边右移，让和变大
                    low++;
                } else { // 若左右相加比较大，右边左移，让和变小
                    high--;
                }
            }
        }
        return res;
    }
}
