package LC400_06_DP;

/**
 * Created by Gary on 2019-01-09.
 */
public class LC44 {
    public boolean isMatch(String str, String pattern) {
        if (str == null || pattern == null) return false;
        int indexS = 0, indexP = 0;
        int lenS = str.length();
        int lenP = pattern.length();

        int preP = -1, preS = -1;
        while (indexS < lenS) {
            if (indexP < lenP && machChar(pattern.charAt(indexP), str.charAt(indexS))) {
                indexP++;
                indexS++;
            } else if (indexP < lenP && pattern.charAt(indexP) == '*') {
                preS = indexS;
                preP = indexP;
                indexP++;
            } else if (preP != -1) {
                indexP = preP;
                indexP++;
                preS++;
                indexS = preS;
            } else {
                return false;
            }
        }
        while (indexP < lenP) {
            if (pattern.charAt(indexP) != '*') return false;
            indexP++;
        }
        return true;
    }

    private boolean machChar(char c1, char c2) {
        return c1 == c2 || c1 == '?';
    }
}
