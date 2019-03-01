package LC400_12_BitManipulation;

/**
 * Created by Gary on 2019-02-26.
 */
public class LC371 {
    public int getSum(int a, int b) {
        int sum;
        do {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        } while (b != 0);
        return sum;
    }
}
