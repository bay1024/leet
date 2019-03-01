package LC400_12_BitManipulation;

/**
 * Created by Gary on 2019-02-26.
 */
public class LC191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                num++;
        }
        return num;
    }
}
