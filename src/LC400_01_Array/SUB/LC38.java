package LC400_01_Array.SUB;

/**
 */
public class LC38 {
    public String countAndSay(int n) {
        String s = "1";
        if (n == 1) return s;
        StringBuilder sb = new StringBuilder();
        int i, count, repeat = 0;
        while (++repeat < n) {
            count = 1;
            sb.setLength(0);
            for (i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    count++;
                }
                else {
                    sb.append(count).append(s.charAt(i - 1));
                    count = 1;
                }
            }
            sb.append(count).append(s.charAt(i - 1));
            s = sb.toString();
        }
        return s;
    }
}
