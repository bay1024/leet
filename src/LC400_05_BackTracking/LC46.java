package LC400_05_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 2019-01-13.
 */
public class LC46 {
    // time: O(n!) space: O(n)
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, res, list);
            list.remove(list.size() - 1);
        }
    }
}
