package LC400_02_String;

/**
 * Created by Gary on 11/23/18.
 */
public class LC5 {
    private int left, maxLength;

    //"babad"
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return s.substring(left, left + maxLength);
    }

    private void extend(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLength < k - j - 1) {
            left = j + 1;
            maxLength = k - j - 1;
        }
    }
}
