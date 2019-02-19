package LC400_05_BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gary on 2019-01-10.
 */
public class LC40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        // 排序是为了在递归中排除重复元素
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int target, int start) {
        // target 已经减到负值 直接退出
        if (target < 0) return;
        // target 为0， 则说明找到了一组结果，加入res
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            /* 过滤重复元素的方法1
            if (i != start && candidates[i] == candidates[i - 1])   continue;
            */
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
            // 过滤重复元素的方法2
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++;
        }
    }
}
