package LC400_02_String;

/**
 * Created by Gary on 11/7/18.
 */
public class LC87 {
    //用来剪枝，判断是否公用相同的字符，因为至少是要保证一致的
    public boolean sameChars(String first, String second) {
        int[] bucket = new int[256];
        for (int i = 0; i < first.length(); i++) {
            bucket[first.charAt(i)]++;
            bucket[second.charAt(i)]--;
        }
        for (int i: bucket) if (i != 0) return false;
        return true;
    }
    /**
     * 任选一个点都可以做调转，遍历一遍
     * s1与s2，在s1上选择一个位置，分为左边s1left和右边s1right;
     * 那么在s2上可以按照这个长度，和规则找出两种情况c1和c2，使用递归判断s1和c1或c2其中一组是否是Scramble
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        for (int i = 1; i < s1.length(); i++) {
            String s1left = s1.substring(0, i);
            String s1right = s1.substring(i);
            //case 1
            String c1left = s2.substring(0, i);
            String c1right = s2.substring(i);
            if (sameChars(s1left, c1left) && sameChars(s1right, c1right)
                    && isScramble(s1left, c1left) && isScramble(s1right, c1right))
                return true;
            //case 2
            String c2left = s2.substring(s2.length() - i);
            String c2right = s2.substring(0, s2.length() - i);
            if (sameChars(s1left, c2left) && sameChars(s1right, c2right)
                    && isScramble(s1left, c2left) && isScramble(s1right, c2right))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = new LC87().sameChars("abc", "cba");
        System.out.println(b);
    }
}
