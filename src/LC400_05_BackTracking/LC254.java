package LC400_05_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 2019-01-13.
 */
public class LC254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), n, 2);
        return result;
    }

    public void helper(List<List<Integer>> result, ArrayList<Integer> list, int n, int start) {
        // 当n到达1的时候，就产生了一个结果
        if (n == 1) {
            if (list.size() > 1) { // 如果结果的size > 1，才是有效结果，加入结果集
                result.add(new ArrayList<>(list));
                return;
            }
        }
        // 从start位置开始遍历
        for (int i = start; i <= n; i++) {
            if (n % i == 0) { // 找到能整除的
                list.add(i);
                helper(result, list, n / i, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
