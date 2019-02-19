package LC400_02_String;

/**
 * Created by Gary on 11/18/18.
 */
public class LC76 {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        int begin = 0, start = 0, end = 0, min = Integer.MAX_VALUE, total = t.length();

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) total--;
            while (total == 0) {
                if (end - start < min) {
                    min = end - start;
                    begin = start;
                }
                if (map[s.charAt(start++)]++ == 0) total++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(begin, begin + min);
    }
}
