package LC400_02_String;

/**
 * Created by Gary on 11/21/18.
 */
public class LC340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int res = 0;
        int num = 0;
        int j = 0; // 滑动窗口左边
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(j++)] > 0) {
                    //printCount(count);
                }
                num--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
