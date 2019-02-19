package LC400_02_String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Gary on 11/23/18.
 */
public class LC301 {
    public List<String> removeInvalidParentheses(String s) {
        int rml = 0, rmr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rml++;
            } else if (s.charAt(i) == ')') {
                if (rml != 0)   rml--;
                else            rmr++;
            }
        }
        Set<String> result = new HashSet<>();
        dfs(s, 0, result, new StringBuilder(), rml, rmr, 0);
        return new ArrayList<>(result);

    }


    private void dfs(String s, int i, Set<String> result, StringBuilder sb, int rml, int rmr, int open) {
        if (rml < 0 || rmr < 0 || open < 0) return;
        if (i == s.length()) {
            if (rml == 0 && rmr == 0 && open == 0) result.add(sb.toString());
            return;
        }
        char c = s.charAt(i);
        int len = sb.length();
        if (c == '(') {
            dfs(s, i + 1, result, sb, rml - 1, rmr, open);
            dfs(s, i + 1, result, sb.append(c), rml, rmr, open + 1);
        } else if (c == ')') {
            dfs(s, i + 1, result, sb, rml, rmr - 1, open);
            dfs(s, i + 1, result, sb.append(c), rml, rmr, open - 1);
        } else {
            dfs(s, i + 1, result, sb.append(c), rml, rmr, open);
        }
        sb.setLength(len);
    }
}
