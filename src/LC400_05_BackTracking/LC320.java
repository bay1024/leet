package LC400_05_BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary on 2019-01-13.
 */
public class LC320 {

    public List<String> generateAbbreviations(String word) {
        return solution4(word);
    }

    public List<String> solution4(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, 0, "", 0);
        return res;
    }

    private void helper(List<String> res, String word, int pos, String current, int count) {
        if (pos == word.length()) {
            if (count > 0) current += count;
            res.add(current);
        } else {
            helper(res, word, pos + 1, current, count + 1);
            helper(res, word, pos + 1, current + (count > 0 ? count : "") + word.charAt(pos), 0);
        }
    }

    List<String> solution1(String word) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, word.length()); i++) {
            StringBuilder cur = new StringBuilder();
            int cnt = 0;
            for (int j = 0; j < word.length(); j++) {
                if (((i >> j) & 1) == 1) cnt++;
                else {
                    if (cnt != 0) {
                        cur.append(cnt);
                        cnt = 0;
                    }
                    cur.append(word.charAt(j));
                }
            }
            if (cnt > 0) cur.append(cnt);
            res.add(cur.toString());
            cur.delete(0, cur.length());
        }
        return res;
    }
}
