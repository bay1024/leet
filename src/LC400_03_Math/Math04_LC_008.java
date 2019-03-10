package LC400_03_Math;

/**
 * Created by Gary on 2019-02-27.
 */
public class Math04_LC_08 {
    public int myAtoi(String str) {
        int len = str.length();
        if (len == 0) return 0;
        long result = 0;
        boolean flag;
        int index = 0;

        while (str.charAt(index) == ' ') index++;

        char ch = str.charAt(index);
        if (ch == '+') {
            flag = true;
            index++;
        } else if (ch == '-') {
            flag = false;
            index++;
        } else if (ch >= '0' && ch <= '9') {
            flag = true;
        } else {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') break;
            sb.append(c);
        }
        String temp = sb.toString();
        for (int i = 0; i < temp.length(); i++) {
            result += (int) (Math.pow(10, temp.length() - i - 1)) * (temp.charAt(i) - '0');
        }
        if (flag && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (!flag && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) (flag ? result : -result);
    }
}
