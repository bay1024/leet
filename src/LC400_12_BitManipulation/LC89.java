package LC400_12_BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 2019-02-26.
 */
public class LC89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n <= 1) {
            for (int i = 0; i <= n; i++) {
                result.add(i);
            }
            return result;
        }
        result = grayCode(n - 1);
        List<Integer> r1 = reverse(result);
        int x = 1 << (n - 1);
        for (int i = 0; i < r1.size(); i++) {
            r1.set(i, r1.get(i) + x);
        }
        result.addAll(r1);
        return result;
    }

    private List<Integer> reverse(List<Integer> result) {
        List<Integer> rev = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            rev.add(result.get(i));
        }
        return rev;
    }
}
