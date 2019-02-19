package LC400_05_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 2019-01-13.
 */
public class LC93 {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        dfs(result, s, 0, list);
        ArrayList<String> finalResult = new ArrayList<>();
        for (ArrayList<String> l : result) {
            StringBuilder sb = new StringBuilder();
            for (String str : l) {
                sb.append(str).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            finalResult.add(sb.toString());
        }
        return finalResult;
    }

    public void dfs(ArrayList<ArrayList<String>> result, String s, int start, ArrayList<String> t) {
        // if already get 4 numbers, but s is not consumed, return
        if (t.size() >= 4 && start != s.length()) return;
        // make sure t's size + remaining LC400_02_String's length >= 4
        if ((t.size()) + s.length() - start + 1 < 4) return;
        // t's size is 4 and no remaining part that is not consumed
        if (t.size() == 4 && start == s.length()) {
            ArrayList<String> temp = new ArrayList<>(t);
            result.add(temp);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            // make sure the index is within the boundary
            if (start + i > s.length()) break;
            String sub = s.substring(start, start + i);
            // handle case like 001. i.e., if length > 1 and first char is 0, ignore the case.
            if (i > 1 && s.charAt(start) == '0') break;
            // make sure each number <= 255
            if (Integer.valueOf(sub) > 255) break;

            t.add(sub);
            dfs(result, s, start + i, t);
            t.remove(t.size() - 1);
        }
    }
}
