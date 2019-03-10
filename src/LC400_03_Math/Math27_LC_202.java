package LC400_03_Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 2019-03-03.
 */
public class Math27_LC_202 {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        if (n == 0) return false;
        if (n == 1) return true;
        while (n != 1) {
            int cur = squareCompute(n);
            if (list.contains(cur)) return false;
            if (cur == 1) return true;
            else {
                list.add(cur);
                n = cur;
            }
        }
        return true;
    }

    public int squareCompute(int m) {
        int result = 0;
        String s = String.valueOf(m);
        for (int i = 0; i < s.length(); i++) {
            String t = String.valueOf(s.charAt(i));
            result += Math.pow(Integer.parseInt(t), 2);
        }
        return result;
    }
}
