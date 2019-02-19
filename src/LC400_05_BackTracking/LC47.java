package LC400_05_BackTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Gary on 2019-01-13.
 */
public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        // 排序，为了去重
        Arrays.sort(nums);
        helper(res, nums, new LinkedList<>(), new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, LinkedList<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                helper(res, nums, list, used);
                used[i] = false;
                list.remove(list.size() - 1);
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            }
        }
    }
}
