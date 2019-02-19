package LC400_02_String;

/**
 * Created by Gary on 11/7/18.
 */
public class LC6 {
    public String convert(String s, int numRows) {
        if (numRows == 1)   return s;
        StringBuilder sb = new StringBuilder();
        int step = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == (numRows - 1)) {// first and last row
                for (int j = i; j < s.length(); j += step) {
                    sb.append(s.charAt(j));
                }
            } else { // rows in middle
                int j = i;
                boolean flag = true;
                int step1 = 2 * (numRows - 1 - i);
                int step2 = step - step1;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    if (flag)   j += step1;
                    else        j += step2;
                    flag = !flag;
                }
            }
        }
        return sb.toString();
    }
}
