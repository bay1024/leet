package LC400_03_Math;

/**
 * Created by Gary on 2019-02-27.
 */
public class Math11_LC_367 {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left, mid, right, squ;
        left = 1;
        right = num / 2;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            squ = mid * mid;
            if (squ == num) return true;
            else if (squ < num) left = mid;
            else right = mid;
        }
        return left * left == num || right * right == num;
    }
}
