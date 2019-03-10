package LC400_03_Math;

/**
 * Created by Gary on 2019-03-02.
 */
public class Math22_LC_342 {
    public boolean isPowerOfFour(int num) {
        return num > 0 && ((num & (num-1)) == 0) && ((num & 0x55555555) > 0);
    }
}
