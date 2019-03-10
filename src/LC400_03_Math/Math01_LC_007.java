package LC400_03_Math;

/**
 * Created by Gary on 2019-02-27.
 */
public class Math01_LC_07 {
    public int reverse(int n) {
        int newN = 0;
        while (n != 0) {
            int temp = newN * 10 + n % 10;
            n /= 10;
            if (temp / 10 != newN) {
                newN = 0;
                break;
            }
            newN = temp;
        }
        return newN;
    }
}
