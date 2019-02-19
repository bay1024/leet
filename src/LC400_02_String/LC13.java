package LC400_02_String;

/**
 * Created by Gary on 11/12/18.
 */
public class LC13 {
    public int char2Int(char c) {
        int d = 0;
        switch (c) {
            case 'I':
                d = 1;
                break;
            case 'V':
                d = 5;
                break;
            case 'X':
                d = 10;
                break;
            case 'L':
                d = 50;
                break;
            case 'C':
                d = 100;
                break;
            case 'D':
                d = 500;
                break;
            case 'M':
                d = 1000;
                break;
        }
        return d;
    }

    public int romanToInt(String s) {
        int i, total, pre, curr;
        total = char2Int(s.charAt(0));
        for (i = 1; i < s.length(); i++) {
            pre = char2Int(s.charAt(i - 1));
            curr = char2Int(s.charAt(i));
            if (curr <= pre)
                total += curr;
            else
                total = total - pre * 2 + curr;
        }
        return total;
    }
}
