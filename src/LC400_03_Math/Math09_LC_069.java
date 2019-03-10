package LC400_03_Math;

/**
 * Created by Gary on 2019-02-27.
 */
public class Math09_LC_69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1;
        int right = x / 2 + 1;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) right = mid - 1;
            else {
                if (mid + 1 > x / (mid + 1)) return mid;
                left = mid + 1;
            }
        }
    }
}
