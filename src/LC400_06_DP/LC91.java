package LC400_06_DP;

/**
 * Created by Gary on 2019-01-09.
 */
public class LC91 {
    private boolean isValid(int a) {
        return a != 0 && a <= 26;
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = isValid(Character.getNumericValue(s.charAt(len - 1))) ? 1 : 0;
        for (int i = len - 2; i >= 0; i--) {
            int oneDigit = Character.getNumericValue(s.charAt(i));
            int twoDigits = Integer.parseInt(s.substring(i, i + 2));
            dp[i] = isValid(oneDigit) ? (dp[i + 1] + (isValid(twoDigits) ? dp[i + 2] : 0)) : 0;
        }
        return dp[0];
    }
}
