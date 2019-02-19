package LC400_02_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gary on 11/15/18.
 */
public class LC247 {
    public List<String> findStrobogrammatic2(int n) {
        List<String> one = Arrays.asList("0", "1", "8"), two = Arrays.asList(""), r = two;
        if (n % 2 == 1) r = one;
        for (int i = (n % 2) + 2; i <= n; i += 2) {
            List<String> newList = new ArrayList<>();
            for (String str : r) {
                if (i != n)
                    newList.add("0" + str + "0");
                newList.add("1" + str + "1");
                newList.add("6" + str + "9");
                newList.add("8" + str + "8");
                newList.add("9" + str + "6");
            }
            r = newList;
        }
        return r;
    }

    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}
