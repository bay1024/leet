package LC400_03_Math;

/**
 * Created by Gary on 2019-02-27.
 */
public class Math05_LC_258 {
    public int addDigits(int num) {
        String str = String.valueOf(num);
        if (str.length() == 1) return Integer.parseInt(str);
        else {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                sum += ch - '0';
            }
            return addDigits(sum);
        }
    }
}
