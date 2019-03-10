package LC400_03_Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gary on 2019-03-02.
 */
public class Math19_LC_018 {
    // time : O(n^3)    space : O(n)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        // 和前面两题一样；边界覆盖
        for (int i = 0; i < nums.length - 3; i++) {
            // 外层去重复
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 内层去重复
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int low = j + 1, high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }
}
