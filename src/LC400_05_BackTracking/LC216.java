package LC400_05_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 2019-01-10.
 */
public class LC216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int k, int target, int start) {
        if (target < 0) return; // 目标已经减为负数，就直接return
        if (k == 0 && target == 0) { // 目标为0 且需要的个数也为0，就说明找到了一个结果，加入结果集，返回
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            // 如果要加的数字已经超过剩余，就不用往下进行了
            if (i > target) break;
            list.add(i);
            helper(res, list, k - 1, target - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
